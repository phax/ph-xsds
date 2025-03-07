/*
 * Copyright (C) 2016-2025 Philip Helger (www.helger.com)
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

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import com.helger.jaxb.GenericJAXBMarshaller;

public final class ReadFuncTest
{
  @Test
  public void testReadServiceMetadata ()
  {
    for (final String sName : new String [] { "servicemetadata1.xml",
                                              "servicemetadata2-unsigned.xml",
                                              "servicemetadata3-unsigned.xml" })
    {
      final File aXML = new File ("src/test/resources/" + sName);
      final ServiceMetadataType aSG = new GenericJAXBMarshaller <> (ServiceMetadataType.class,
                                                                    CBDXRSMP2.getAllXSDResourceServiceMetadata (),
                                                                    new ObjectFactory ()::createServiceMetadata).read (aXML);
      assertNotNull ("Failed to read " + sName, aSG);
    }
  }
}
