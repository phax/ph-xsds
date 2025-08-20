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

import com.helger.unittest.support.TestHelper;

public final class SignatureTypeTest
{
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
}
