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
package com.helger.xsds.xmlenc11;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xsds.xmldsig.CXMLDSig;
import com.helger.xsds.xmlenc.CXMLEnc;

/**
 * Utility class for this schema module
 *
 * @author Philip Helger
 */
@Immutable
public final class CXMLEnc11
{
  public static final String DEFAULT_PREFIX = "dsig11";
  public static final String NAMESPACE_URI = "http://www.w3.org/2009/xmlenc11#";

  private CXMLEnc11 ()
  {}

  /**
   * @return A list of all includes in the correct order. Never
   *         <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDIncludes ()
  {
    return new CommonsArrayList <> (CXMLDSig.getXSDResource (), CXMLEnc.getXSDResource ());
  }

  // Note: requires XMLDSig 1.0 schema
  // Note: requires XMLEnc 1.0 schema
  @Nonnull
  public static final ClassPathResource getXSDResource ()
  {
    return new ClassPathResource ("/schemas/xenc-schema-11.xsd", CXMLEnc11.class.getClassLoader ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDResource ());
    return ret;
  }
}
