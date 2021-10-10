/*
 * Copyright (C) 2016-2021 Philip Helger (www.helger.com)
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
package com.helger.xsds.bdxr.smp2;

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
 * Test class for class {@link CBDXRSMP2}.
 *
 * @author Philip Helger
 */
public final class CBDXRSMP2Test
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CBDXRSMP2.getXSDResourceUnqualifiedDataTypes ());
    assertTrue (CBDXRSMP2.getXSDResourceUnqualifiedDataTypes ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceQualifiedDataTypes ());
    assertTrue (CBDXRSMP2.getXSDResourceQualifiedDataTypes ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceBasicComponents ());
    assertTrue (CBDXRSMP2.getXSDResourceBasicComponents ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceExtensionContentDataType ());
    assertTrue (CBDXRSMP2.getXSDResourceExtensionContentDataType ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceExtensionComponents ());
    assertTrue (CBDXRSMP2.getXSDResourceExtensionComponents ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourcePayloadContentDataType ());
    assertTrue (CBDXRSMP2.getXSDResourcePayloadContentDataType ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceAggregateComponents ());
    assertTrue (CBDXRSMP2.getXSDResourceAggregateComponents ().exists ());

    assertNotNull (CBDXRSMP2.getXSDResourceServiceGroup ());
    assertTrue (CBDXRSMP2.getXSDResourceServiceGroup ().exists ());
    assertEquals (CBDXRSMP2.getXSDResourceServiceGroup (), CBDXRSMP2.getXSDResourceServiceGroup ());
    assertNotSame (CBDXRSMP2.getXSDResourceServiceGroup (), CBDXRSMP2.getXSDResourceServiceGroup ());

    assertNotNull (CBDXRSMP2.getXSDResourceServiceMetadata ());
    assertTrue (CBDXRSMP2.getXSDResourceServiceMetadata ().exists ());
    assertEquals (CBDXRSMP2.getXSDResourceServiceMetadata (), CBDXRSMP2.getXSDResourceServiceMetadata ());
    assertNotSame (CBDXRSMP2.getXSDResourceServiceMetadata (), CBDXRSMP2.getXSDResourceServiceMetadata ());
  }

  @Test
  public void testSchemaCreationServiceGroup ()
  {
    final ICommonsList <ClassPathResource> aList = CBDXRSMP2.getAllXSDIncludes ();
    aList.add (CBDXRSMP2.getXSDResourceServiceGroup ());

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }

  @Test
  public void testSchemaCreationServiceGroup2 ()
  {
    final ICommonsList <ClassPathResource> aList = CBDXRSMP2.getAllXSDResourceServiceGroup ();

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }

  @Test
  public void testSchemaCreationServiceMetadata ()
  {
    final ICommonsList <ClassPathResource> aList = CBDXRSMP2.getAllXSDIncludes ();
    aList.add (CBDXRSMP2.getXSDResourceServiceMetadata ());

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }

  @Test
  public void testSchemaCreationServiceMetadata2 ()
  {
    final ICommonsList <ClassPathResource> aList = CBDXRSMP2.getAllXSDResourceServiceMetadata ();

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }
}
