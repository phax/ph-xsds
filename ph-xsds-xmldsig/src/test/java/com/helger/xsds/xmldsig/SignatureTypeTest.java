package com.helger.xsds.xmldsig;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.collection.commons.CommonsArrayList;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.unittest.support.TestHelper;
import com.helger.xml.namespace.MapBasedNamespaceContext;

public final class SignatureTypeTest
{
  private static class Marshaller extends GenericJAXBMarshaller <SignatureType>
  {
    public Marshaller ()
    {
      super (SignatureType.class,
             new CommonsArrayList <> (CXMLDSig.getXSDResource ()),
             new ObjectFactory ()::createSignature);
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger (SignatureTypeTest.class);

  @Test
  public void testDefaultConstructor ()
  {
    final SignatureType signature = new SignatureType ();
    assertNotNull (signature);
    assertNull (signature.getSignedInfo ());
    assertNull (signature.getSignatureValue ());
    assertNull (signature.getKeyInfo ());
    assertNull (signature.getId ());
    assertNotNull (signature.getObject ());
    assertTrue (signature.getObject ().isEmpty ());
  }

  @Test
  public void testSignedInfoGetterSetter ()
  {
    final SignatureType signature = new SignatureType ();
    final SignedInfoType signedInfo = new SignedInfoType ();

    signature.setSignedInfo (signedInfo);
    assertEquals (signedInfo, signature.getSignedInfo ());

    signature.setSignedInfo (null);
    assertNull (signature.getSignedInfo ());
  }

  @Test
  public void testSignatureValueGetterSetter ()
  {
    final SignatureType signature = new SignatureType ();
    final SignatureValueType signatureValue = new SignatureValueType ();

    signature.setSignatureValue (signatureValue);
    assertEquals (signatureValue, signature.getSignatureValue ());

    signature.setSignatureValue ((SignatureValueType) null);
    assertNull (signature.getSignatureValue ());
  }

  @Test
  public void testKeyInfoGetterSetter ()
  {
    final SignatureType signature = new SignatureType ();
    final KeyInfoType keyInfo = new KeyInfoType ();

    signature.setKeyInfo (keyInfo);
    assertEquals (keyInfo, signature.getKeyInfo ());

    signature.setKeyInfo (null);
    assertNull (signature.getKeyInfo ());
  }

  @Test
  public void testIdGetterSetter ()
  {
    final SignatureType signature = new SignatureType ();
    final String id = "test-id";

    signature.setId (id);
    assertEquals (id, signature.getId ());

    signature.setId (null);
    assertNull (signature.getId ());
  }

  @Test
  public void testObjectList ()
  {
    final SignatureType signature = new SignatureType ();

    // Test initial state
    assertTrue (signature.hasNoObjectEntries ());
    assertFalse (signature.hasObjectEntries ());
    assertEquals (0, signature.getObjectCount ());

    // Add objects
    final ObjectType obj1 = new ObjectType ();
    final ObjectType obj2 = new ObjectType ();

    signature.addObject (obj1);
    assertEquals (1, signature.getObjectCount ());
    assertTrue (signature.hasObjectEntries ());
    assertFalse (signature.hasNoObjectEntries ());
    assertEquals (obj1, signature.getObjectAtIndex (0));

    signature.addObject (obj2);
    assertEquals (2, signature.getObjectCount ());
    assertEquals (obj2, signature.getObjectAtIndex (1));

    // Test setting list directly
    final List <ObjectType> newList = new ArrayList <> ();
    final ObjectType obj3 = new ObjectType ();
    newList.add (obj3);

    signature.setObject (newList);
    assertEquals (1, signature.getObjectCount ());
    assertEquals (obj3, signature.getObjectAtIndex (0));

    // Test setting null list
    signature.setObject (null);
    assertNotNull (signature.getObject ()); // Should auto-initialize
    assertEquals (0, signature.getObjectCount ());
  }

  @Test (expected = IndexOutOfBoundsException.class)
  public void testGetObjectAtIndexOutOfBounds ()
  {
    final SignatureType signature = new SignatureType ();
    signature.getObjectAtIndex (0);
  }

  @Test
  public void testSignatureValueExtenderMethods ()
  {
    final SignatureType signature = new SignatureType ();
    final byte [] testValue = { 1, 2, 3, 4, 5 };

    // Test setting value
    final SignatureValueType result = signature.setSignatureValue (testValue);
    assertNotNull (result);
    assertArrayEquals (testValue, signature.getSignatureValueValue ());
    assertArrayEquals (testValue, signature.getSignatureValue ().getValue ());

    // Test with null value
    signature.setSignatureValue ((byte []) null);
    assertNull (signature.getSignatureValueValue ());

    // Test when SignatureValue is null
    signature.setSignatureValue ((SignatureValueType) null);
    assertNull (signature.getSignatureValueValue ());
  }

  @Test
  public void testEquals ()
  {
    final SignatureType sig1 = new SignatureType ();
    final SignatureType sig2 = new SignatureType ();

    // Test equality with empty objects
    assertEquals (sig1, sig2);
    assertEquals (sig1, sig1);

    // Test with different IDs
    sig1.setId ("id1");
    assertNotEquals (sig1, sig2);

    sig2.setId ("id1");
    assertEquals (sig1, sig2);

    // Test with different SignedInfo
    sig1.setSignedInfo (new SignedInfoType ());
    assertNotEquals (sig1, sig2);

    sig2.setSignedInfo (new SignedInfoType ());
    assertEquals (sig1, sig2);

    // Test with null
    assertNotEquals (sig1, null);

    // Test with different class
    assertNotEquals (sig1, "not a signature");
  }

  @Test
  public void testHashCode ()
  {
    final SignatureType sig1 = new SignatureType ();
    final SignatureType sig2 = new SignatureType ();

    // Equal objects should have equal hash codes
    assertEquals (sig1.hashCode (), sig2.hashCode ());

    sig1.setId ("test-id");
    sig2.setId ("test-id");
    assertEquals (sig1.hashCode (), sig2.hashCode ());
  }

  @Test
  public void testToString ()
  {
    final SignatureType signature = new SignatureType ();
    String toString = signature.toString ();

    assertNotNull (toString);
    assertTrue (toString.contains ("SignatureType"));

    signature.setId ("test-id");
    toString = signature.toString ();
    assertTrue (toString.contains ("test-id"));
  }

  @Test
  public void testClone ()
  {
    final SignatureType original = new SignatureType ();
    original.setId ("test-id");
    original.setSignedInfo (new SignedInfoType ());
    original.setSignatureValue (new SignatureValueType ());
    original.setKeyInfo (new KeyInfoType ());
    original.addObject (new ObjectType ());

    final SignatureType clone = original.clone ();

    assertNotSame (original, clone);
    assertEquals (original, clone);
    assertEquals (original.getId (), clone.getId ());
    assertEquals (original.getSignedInfo (), clone.getSignedInfo ());
    assertEquals (original.getSignatureValue (), clone.getSignatureValue ());
    assertEquals (original.getKeyInfo (), clone.getKeyInfo ());
    assertEquals (original.getObjectCount (), clone.getObjectCount ());

    // Verify deep cloning
    assertNotSame (original.getSignedInfo (), clone.getSignedInfo ());
    assertNotSame (original.getSignatureValue (), clone.getSignatureValue ());
    assertNotSame (original.getKeyInfo (), clone.getKeyInfo ());
    assertNotSame (original.getObject (), clone.getObject ());

    TestHelper.testDefaultImplementationWithEqualContentObject (original, clone);
  }

  @Test
  public void testCloneTo ()
  {
    final SignatureType source = new SignatureType ();
    source.setId ("source-id");
    source.setSignedInfo (new SignedInfoType ());
    source.addObject (new ObjectType ());

    final SignatureType target = new SignatureType ();
    target.setId ("target-id");

    source.cloneTo (target);

    assertEquals (source.getId (), target.getId ());
    assertEquals (source.getObjectCount (), target.getObjectCount ());
    assertNotSame (source.getObject (), target.getObject ());
  }

  @Test
  public void testRead ()
  {
    final Marshaller m = new Marshaller ();
    m.setFormattedOutput (false);
    final MapBasedNamespaceContext aNSCtx = new MapBasedNamespaceContext ();
    aNSCtx.addMapping ("dsig", "http://www.w3.org/2000/09/xmldsig#");
    aNSCtx.addMapping ("etsi", "http://uri.etsi.org/01903/v1.1.1#");
    m.setNamespaceContext (aNSCtx);

    final String s1 = "<dsig:Signature Id=\"signature-1-1\" xmlns:dsig=\"http://www.w3.org/2000/09/xmldsig#\"><dsig:SignedInfo><dsig:CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" /><dsig:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256\" /><dsig:Reference Id=\"reference-1-1\" URI=\"\"><dsig:Transforms><dsig:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /></dsig:Transforms><dsig:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><dsig:DigestValue>8my/qIp2RKQVIE4UerdnmPIkUtbhYpRUt76PdCqMLfM=</dsig:DigestValue></dsig:Reference><dsig:Reference Id=\"etsi-data-reference-1-1\" Type=\"http://uri.etsi.org/01903/v1.1.1#SignedProperties\" URI=\"\"><dsig:Transforms><dsig:Transform Algorithm=\"http://www.w3.org/2002/06/xmldsig-filter2\"><xpf:XPath Filter=\"intersect\" xmlns:etsi=\"http://uri.etsi.org/01903/v1.1.1#\" xmlns:xpf=\"http://www.w3.org/2002/06/xmldsig-filter2\">//*[@Id='etsi-signed-1-1']/etsi:QualifyingProperties/etsi:SignedProperties</xpf:XPath></dsig:Transform></dsig:Transforms><dsig:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><dsig:DigestValue>ME9JaROX8qIm8BUfxsiaXL+iaTh4tuI2+il/dKUW4uc=</dsig:DigestValue></dsig:Reference></dsig:SignedInfo><dsig:SignatureValue>jKzVMbmJQzU3RWtxNUP9MSxbRt1NRmCbEbGxCUUWgqUuH6QeVF8QSNr2zgNcq/bOa11b1sQAAP8E8RsIJiZ3mQ==</dsig:SignatureValue><dsig:KeyInfo><dsig:X509Data><dsig:X509Certificate>MIIEnjCCA4agAwIBAgIDCFB9MA0GCSqGSIb3DQEBBQUAMIGdMQswCQYDVQQGEwJBVDFIMEYGA1UECgw/QS1UcnVzdCBHZXMuIGYuIFNpY2hlcmhlaXRzc3lzdGVtZSBpbSBlbGVrdHIuIERhdGVudmVya2VociBHbWJIMSEwHwYDVQQLDBhhLXNpZ24tcHJlbWl1bS1tb2JpbGUtMDMxITAfBgNVBAMMGGEtc2lnbi1wcmVtaXVtLW1vYmlsZS0wMzAeFw0xMDEyMjIxMTM3NTNaFw0xNTEyMjIxMTM3NTNaMFoxCzAJBgNVBAYTAkFUMRQwEgYDVQQDDAtKb3NlZiBCb2dhZDEOMAwGA1UEBAwFQm9nYWQxDjAMBgNVBCoMBUpvc2VmMRUwEwYDVQQFEww3MTI0MDUxNjk1MDkwWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAATMtoznQ8NUL5OApYePUTDhktQcUXxfsHHR/A8Sx6XpdbGKRFLF4nO3KnAssrlN6erTPaSQsc+SfXC8xzWD0RTGo4IB8jCCAe4wEwYDVR0jBAwwCoAIS7hh11/WSGMwJwYIKwYBBQUHAQMBAf8EGDAWMAgGBgQAjkYBATAKBggrBgEFBQcLATB+BggrBgEFBQcBAQRyMHAwRQYIKwYBBQUHMAKGOWh0dHA6Ly93d3cuYS10cnVzdC5hdC9jZXJ0cy9hLXNpZ24tcHJlbWl1bS1tb2JpbGUtMDNhLmNydDAnBggrBgEFBQcwAYYbaHR0cDovL29jc3AuYS10cnVzdC5hdC9vY3NwMGAGA1UdIARZMFcwSwYGKigAEQEUMEEwPwYIKwYBBQUHAgEWM2h0dHA6Ly93d3cuYS10cnVzdC5hdC9kb2NzL2NwL2Etc2lnbi1wcmVtaXVtLW1vYmlsZTAIBgYEAIswAQEwgZ0GA1UdHwSBlTCBkjCBj6CBjKCBiYaBhmxkYXA6Ly9sZGFwLmEtdHJ1c3QuYXQvb3U9YS1zaWduLXByZW1pdW0tbW9iaWxlLTAzLG89QS1UcnVzdCxjPUFUP2NlcnRpZmljYXRlcmV2b2NhdGlvbmxpc3Q/YmFzZT9vYmplY3RjbGFzcz1laWRDZXJ0aWZpY2F0aW9uQXV0aG9yaXR5MBEGA1UdDgQKBAhCauHetOTWqDAOBgNVHQ8BAf8EBAMCBsAwCQYDVR0TBAIwADANBgkqhkiG9w0BAQUFAAOCAQEAm2NYiJMygvQFGwFtzS7/+ch2qv+3smCizJrshiB33ETmjRIdqqRcACDAJ/yizP2P/eIoLclPOqrMjLJmwFBwvkZw3MdBKQ4x07kT5enQvx4zYsTtZA3VUw6+KCnpVSj+mrvw3mEwTEGVfkQTZLAIl0uz8kjtiFTGfUUEKmBTztut71L0GRS8iw1RTxUM6DKeJA3OmAmU+ytvuemCXn1qWQACVn5oMOxprgvOJw4qIU/y+nIp4dzXYjzEG9U5waZgGm68F/KcWnYNNNhq1sYd2NDvtCLgjdLEPeZBwbwJQXo037IGLiXPXu0JPXISXnGLyPaRXEGfFMYJKNGOLnahSw==</dsig:X509Certificate></dsig:X509Data><dsig:KeyName>SERIALNUMBER=712405169509, G=Josef, SN=Bogad, CN=Josef Bogad, C=AT</dsig:KeyName></dsig:KeyInfo><dsig:Object Id=\"etsi-signed-1-1\"><etsi:QualifyingProperties Target=\"#signature-1-1\" xmlns:etsi=\"http://uri.etsi.org/01903/v1.1.1#\"><etsi:SignedProperties><etsi:SignedSignatureProperties><etsi:SigningTime>2012-03-12T11:01:14Z</etsi:SigningTime><etsi:SigningCertificate><etsi:Cert><etsi:CertDigest><etsi:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" /><etsi:DigestValue>yexQhxCAH1rgoZ0uCc1+d8ylaH4=</etsi:DigestValue></etsi:CertDigest><etsi:IssuerSerial><dsig:X509IssuerName>CN=a-sign-premium-mobile-03,OU=a-sign-premium-mobile-03,O=A-Trust Ges. f. Sicherheitssysteme im elektr. Datenverkehr GmbH,C=AT</dsig:X509IssuerName><dsig:X509SerialNumber>544893</dsig:X509SerialNumber></etsi:IssuerSerial></etsi:Cert></etsi:SigningCertificate><etsi:SignaturePolicyIdentifier><etsi:SignaturePolicyImplied /></etsi:SignaturePolicyIdentifier></etsi:SignedSignatureProperties><etsi:SignedDataObjectProperties><etsi:DataObjectFormat ObjectReference=\"#reference-1-1\"><etsi:MimeType>text/html</etsi:MimeType></etsi:DataObjectFormat></etsi:SignedDataObjectProperties></etsi:SignedProperties></etsi:QualifyingProperties></dsig:Object></dsig:Signature>";
    final String s2 = "<dsig:Signature Id=\"signature-1-1\"\n" +
                      "    xmlns:dsig=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                      "    <dsig:SignedInfo>\n" +
                      "      <dsig:CanonicalizationMethod\n" +
                      "        Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />\n" +
                      "      <dsig:SignatureMethod\n" +
                      "        Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256\" />\n" +
                      "      <dsig:Reference Id=\"reference-1-1\" URI=\"\">\n" +
                      "        <dsig:Transforms>\n" +
                      "          <dsig:Transform\n" +
                      "            Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" />\n" +
                      "        </dsig:Transforms>\n" +
                      "        <dsig:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" />\n" +
                      "        <dsig:DigestValue>XsJgseX40nkSROUnpZyYMR+2A4O9ZluogDDfG+L+290=</dsig:DigestValue>\n" +
                      "      </dsig:Reference>\n" +
                      "      <dsig:Reference Id=\"etsi-data-reference-1-1\"\n" +
                      "        Type=\"http://uri.etsi.org/01903/v1.1.1#SignedProperties\" URI=\"\">\n" +
                      "        <dsig:Transforms>\n" +
                      "          <dsig:Transform Algorithm=\"http://www.w3.org/2002/06/xmldsig-filter2\">\n" +
                      "            <xpf:XPath Filter=\"intersect\"\n" +
                      "              xmlns:etsi=\"http://uri.etsi.org/01903/v1.1.1#\"\n" +
                      "              xmlns:xpf=\"http://www.w3.org/2002/06/xmldsig-filter2\">\n" +
                      "              //*[@Id='etsi-signed-1-1']/etsi:QualifyingProperties/etsi:SignedProperties</xpf:XPath>\n" +
                      "          </dsig:Transform>\n" +
                      "        </dsig:Transforms>\n" +
                      "        <dsig:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" />\n" +
                      "        <dsig:DigestValue>WznHKU7GxtSXdOBQRWlQRw79RWxTXP0gvIfV4HZ2XJs=</dsig:DigestValue>\n" +
                      "      </dsig:Reference>\n" +
                      "    </dsig:SignedInfo>\n" +
                      "    <dsig:SignatureValue>\n" +
                      "      tOukTqt+LXUhmYrBno7YCaJGk6dNI70mLYsmbXsJEwS4UKvlhixgeBVR/AeZ7TYb15QNvVTvH/loomYec9kq6Q==</dsig:SignatureValue>\n" +
                      "    <dsig:KeyInfo>\n" +
                      "      <dsig:X509Data><dsig:X509Certificate>MIIEnjCCA4agAwIBAgIDCFB9MA0GCSqGSIb3DQEBBQUAMIGdMQswCQYDVQQGEwJBVDFIMEYGA1UECgw/QS1UcnVzdCBHZXMuIGYuIFNpY2hlcmhlaXRzc3lzdGVtZSBpbSBlbGVrdHIuIERhdGVudmVya2VociBHbWJIMSEwHwYDVQQLDBhhLXNpZ24tcHJlbWl1bS1tb2JpbGUtMDMxITAfBgNVBAMMGGEtc2lnbi1wcmVtaXVtLW1vYmlsZS0wMzAeFw0xMDEyMjIxMTM3NTNaFw0xNTEyMjIxMTM3NTNaMFoxCzAJBgNVBAYTAkFUMRQwEgYDVQQDDAtKb3NlZiBCb2dhZDEOMAwGA1UEBAwFQm9nYWQxDjAMBgNVBCoMBUpvc2VmMRUwEwYDVQQFEww3MTI0MDUxNjk1MDkwWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAATMtoznQ8NUL5OApYePUTDhktQcUXxfsHHR/A8Sx6XpdbGKRFLF4nO3KnAssrlN6erTPaSQsc+SfXC8xzWD0RTGo4IB8jCCAe4wEwYDVR0jBAwwCoAIS7hh11/WSGMwJwYIKwYBBQUHAQMBAf8EGDAWMAgGBgQAjkYBATAKBggrBgEFBQcLATB+BggrBgEFBQcBAQRyMHAwRQYIKwYBBQUHMAKGOWh0dHA6Ly93d3cuYS10cnVzdC5hdC9jZXJ0cy9hLXNpZ24tcHJlbWl1bS1tb2JpbGUtMDNhLmNydDAnBggrBgEFBQcwAYYbaHR0cDovL29jc3AuYS10cnVzdC5hdC9vY3NwMGAGA1UdIARZMFcwSwYGKigAEQEUMEEwPwYIKwYBBQUHAgEWM2h0dHA6Ly93d3cuYS10cnVzdC5hdC9kb2NzL2NwL2Etc2lnbi1wcmVtaXVtLW1vYmlsZTAIBgYEAIswAQEwgZ0GA1UdHwSBlTCBkjCBj6CBjKCBiYaBhmxkYXA6Ly9sZGFwLmEtdHJ1c3QuYXQvb3U9YS1zaWduLXByZW1pdW0tbW9iaWxlLTAzLG89QS1UcnVzdCxjPUFUP2NlcnRpZmljYXRlcmV2b2NhdGlvbmxpc3Q/YmFzZT9vYmplY3RjbGFzcz1laWRDZXJ0aWZpY2F0aW9uQXV0aG9yaXR5MBEGA1UdDgQKBAhCauHetOTWqDAOBgNVHQ8BAf8EBAMCBsAwCQYDVR0TBAIwADANBgkqhkiG9w0BAQUFAAOCAQEAm2NYiJMygvQFGwFtzS7/+ch2qv+3smCizJrshiB33ETmjRIdqqRcACDAJ/yizP2P/eIoLclPOqrMjLJmwFBwvkZw3MdBKQ4x07kT5enQvx4zYsTtZA3VUw6+KCnpVSj+mrvw3mEwTEGVfkQTZLAIl0uz8kjtiFTGfUUEKmBTztut71L0GRS8iw1RTxUM6DKeJA3OmAmU+ytvuemCXn1qWQACVn5oMOxprgvOJw4qIU/y+nIp4dzXYjzEG9U5waZgGm68F/KcWnYNNNhq1sYd2NDvtCLgjdLEPeZBwbwJQXo037IGLiXPXu0JPXISXnGLyPaRXEGfFMYJKNGOLnahSw==</dsig:X509Certificate></dsig:X509Data>\n" +
                      "      <dsig:KeyName>SERIALNUMBER=712405169509, G=Josef, SN=Bogad, CN=Josef Bogad, C=AT</dsig:KeyName>\n" +
                      "    </dsig:KeyInfo>\n" +
                      "    <dsig:Object Id=\"etsi-signed-1-1\">\n" +
                      "      <etsi:QualifyingProperties Target=\"#signature-1-1\"\n" +
                      "        xmlns:etsi=\"http://uri.etsi.org/01903/v1.1.1#\">\n" +
                      "        <etsi:SignedProperties>\n" +
                      "          <etsi:SignedSignatureProperties>\n" +
                      "            <etsi:SigningTime>2011-09-12T08:12:52Z</etsi:SigningTime>\n" +
                      "            <etsi:SigningCertificate>\n" +
                      "              <etsi:Cert>\n" +
                      "                <etsi:CertDigest>\n" +
                      "                  <etsi:DigestMethod\n" +
                      "                    Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" />\n" +
                      "                  <etsi:DigestValue>yexQhxCAH1rgoZ0uCc1+d8ylaH4=</etsi:DigestValue>\n" +
                      "                </etsi:CertDigest>\n" +
                      "                <etsi:IssuerSerial>\n" +
                      "                  <dsig:X509IssuerName>CN=a-sign-premium-mobile-03,OU=a-sign-premium-mobile-03,O=A-Trust\n" +
                      "                    Ges. f. Sicherheitssysteme im elektr. Datenverkehr GmbH,C=AT</dsig:X509IssuerName>\n" +
                      "                  <dsig:X509SerialNumber>544893</dsig:X509SerialNumber>\n" +
                      "                </etsi:IssuerSerial>\n" +
                      "              </etsi:Cert>\n" +
                      "            </etsi:SigningCertificate>\n" +
                      "            <etsi:SignaturePolicyIdentifier>\n" +
                      "              <etsi:SignaturePolicyImplied />\n" +
                      "            </etsi:SignaturePolicyIdentifier>\n" +
                      "          </etsi:SignedSignatureProperties>\n" +
                      "          <etsi:SignedDataObjectProperties>\n" +
                      "            <etsi:DataObjectFormat ObjectReference=\"#reference-1-1\">\n" +
                      "              <etsi:MimeType>text/html</etsi:MimeType>\n" +
                      "            </etsi:DataObjectFormat>\n" +
                      "          </etsi:SignedDataObjectProperties>\n" +
                      "        </etsi:SignedProperties>\n" +
                      "      </etsi:QualifyingProperties>\n" +
                      "    </dsig:Object>\n" +
                      "  </dsig:Signature>";
    int nIdx = 0;
    for (final String s : new String [] { s1, s2 })
    {
      LOGGER.info ("Index " + nIdx);
      final SignatureType aSig = m.read (s);
      assertNotNull (aSig);

      final SignatureType aSig2 = aSig.clone ();
      TestHelper.testDefaultImplementationWithEqualContentObject (aSig, aSig2);

      if (false)
        LOGGER.info (m.getAsString (aSig));

      final SignatureType aSig3 = m.read (m.getAsBytes (aSig));
      TestHelper.testDefaultImplementationWithEqualContentObject (aSig, aSig3);

      aSig2.setId (aSig2.getId () + "x");
      TestHelper.testDefaultImplementationWithDifferentContentObject (aSig, aSig2);
      ++nIdx;
    }
  }
}
