/*
 * Copyright (C) 2016-2022 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.xsds.xmldsig11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import javax.xml.validation.Schema;

import org.junit.Test;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xml.schema.XMLSchemaCache;

/**
 * Test class for class {@link CXMLDSig11}.
 *
 * @author Philip Helger
 */
public final class CXMLDSig11Test
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CXMLDSig11.getXSDResource ());
    assertTrue (CXMLDSig11.getXSDResource ().exists ());
    assertEquals (CXMLDSig11.getXSDResource (), CXMLDSig11.getXSDResource ());
    assertNotSame (CXMLDSig11.getXSDResource (), CXMLDSig11.getXSDResource ());
  }

  @Test
  public void testSchemaCreation ()
  {
    final ICommonsList <ClassPathResource> aList = CXMLDSig11.getAllXSDIncludes ();
    aList.add (CXMLDSig11.getXSDResource ());

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }

  @Test
  public void testSchemaCreation2 ()
  {
    final ICommonsList <ClassPathResource> aList = CXMLDSig11.getAllXSDResources ();

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }
}
