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
package com.helger.xsds.bdxr.smp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    assertNotNull (CBDXRSMP2.getXSDResourceServiceGroup ());
    assertTrue (CBDXRSMP2.getXSDResourceServiceGroup ().exists ());
    assertEquals (CBDXRSMP2.getXSDResourceServiceGroup (), CBDXRSMP2.getXSDResourceServiceGroup ());
    assertNotSame (CBDXRSMP2.getXSDResourceServiceGroup (), CBDXRSMP2.getXSDResourceServiceGroup ());

    assertNotNull (CBDXRSMP2.getXSDResourceServiceMetadata ());
    assertTrue (CBDXRSMP2.getXSDResourceServiceMetadata ().exists ());
    assertEquals (CBDXRSMP2.getXSDResourceServiceMetadata (), CBDXRSMP2.getXSDResourceServiceMetadata ());
    assertNotSame (CBDXRSMP2.getXSDResourceServiceMetadata (), CBDXRSMP2.getXSDResourceServiceMetadata ());
  }
}
