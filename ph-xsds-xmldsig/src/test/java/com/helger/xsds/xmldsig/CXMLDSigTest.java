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
package com.helger.xsds.xmldsig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for class {@link CXMLDSig}.
 *
 * @author Philip Helger
 */
public final class CXMLDSigTest
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CXMLDSig.getXSDResource ());
    assertTrue (CXMLDSig.getXSDResource ().exists ());
    assertEquals (CXMLDSig.getXSDResource (), CXMLDSig.getXSDResource ());
    assertNotSame (CXMLDSig.getXSDResource (), CXMLDSig.getXSDResource ());
  }
}
