/**
 * Copyright (C) 2016-2020 Philip Helger (www.helger.com)
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
package com.helger.xsds.xlink;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xsds.xmlenc.CXML;

/**
 * Utility class for this schema module
 *
 * @author Philip Helger
 */
@Immutable
public final class CXLink
{
  public static final String DEFAULT_PREFIX = "xlink";
  public static final String NAMESPACE_URI = "http://www.w3.org/1999/xlink";

  private CXLink ()
  {}

  /**
   * @return A list of all includes in the correct order. Never
   *         <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDIncludes ()
  {
    return new CommonsArrayList <> (CXML.getXSDResource ());
  }

  // Note: requires XML schema
  @Nonnull
  public static final ClassPathResource getXSDResource ()
  {
    return new ClassPathResource ("/schemas/xlink.xsd", CXLink.class.getClassLoader ());
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
