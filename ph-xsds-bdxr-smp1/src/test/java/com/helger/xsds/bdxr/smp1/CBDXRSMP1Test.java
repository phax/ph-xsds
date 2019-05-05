/**
 * Copyright (C) 2016-2019 Philip Helger (www.helger.com)
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
package com.helger.xsds.bdxr.smp1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.xsds.bdxr.smp1.CBDXRSMP1;

/**
 * Test class for class {@link CBDXRSMP1}.
 *
 * @author Philip Helger
 */
public final class CBDXRSMP1Test
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CBDXRSMP1.getXSDResource ());
    assertTrue (CBDXRSMP1.getXSDResource ().exists ());
    assertEquals (CBDXRSMP1.getXSDResource (), CBDXRSMP1.getXSDResource ());
    assertNotSame (CBDXRSMP1.getXSDResource (), CBDXRSMP1.getXSDResource ());
  }
}