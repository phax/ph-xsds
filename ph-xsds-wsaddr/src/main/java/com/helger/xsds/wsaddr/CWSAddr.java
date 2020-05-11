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
package com.helger.xsds.wsaddr;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.io.resource.ClassPathResource;

/**
 * Utility class for this schema module
 *
 * @author Philip Helger
 */
@Immutable
public final class CWSAddr
{
  public static final String DEFAULT_PREFIX = "wsa";
  public static final String NAMESPACE_URI = "http://www.w3.org/2005/08/addressing";

  private CWSAddr ()
  {}

  @Nonnull
  public static final ClassPathResource getXSDResource ()
  {
    return new ClassPathResource ("/schemas/ws-addr.xsd", CWSAddr.class.getClassLoader ());
  }
}
