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

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

import jakarta.annotation.Nonnull;

/**
 * Utility class for this schema module
 *
 * @author Philip Helger
 */
@Immutable
public final class CBDXRSMP2
{
  public static final String DEFAULT_PREFIX_UNQUALIFIED_DATA_TYPES = "udt";
  public static final String NAMESPACE_URI_UNQUALIFIED_DATA_TYPES = "http://docs.oasis-open.org/bdxr/ns/SMP/2/UnqualifiedDataTypes";

  public static final String DEFAULT_PREFIX_QUALIFIED_DATA_TYPES = "qdt";
  public static final String NAMESPACE_URI_QUALIFIED_DATA_TYPES = "http://docs.oasis-open.org/bdxr/ns/SMP/2/QualifiedDataTypes";

  public static final String DEFAULT_PREFIX_BASIC_COMPONENTS = "smb";
  public static final String NAMESPACE_URI_BASIC_COMPONENTS = "http://docs.oasis-open.org/bdxr/ns/SMP/2/BasicComponents";

  public static final String DEFAULT_PREFIX_EXTENSION_COMPONENTS = "ext";
  public static final String NAMESPACE_URI_EXTENSION_COMPONENTS = "http://docs.oasis-open.org/bdxr/ns/SMP/2/ExtensionComponents";

  public static final String DEFAULT_PREFIX_AGGREGATE_COMPONENTS = "sma";
  public static final String NAMESPACE_URI_AGGREGATE_COMPONENTS = "http://docs.oasis-open.org/bdxr/ns/SMP/2/AggregateComponents";

  public static final String DEFAULT_PREFIX_SERVICE_GROUP = "b2sg";
  public static final String NAMESPACE_URI_SERVICE_GROUP = "http://docs.oasis-open.org/bdxr/ns/SMP/2/ServiceGroup";

  public static final String DEFAULT_PREFIX_SERVICE_METADATA = "b2sm";
  public static final String NAMESPACE_URI_SERVICE_METADATA = "http://docs.oasis-open.org/bdxr/ns/SMP/2/ServiceMetadata";

  private CBDXRSMP2 ()
  {}

  @Nonnull
  private static ClassLoader _getCL ()
  {
    return CBDXRSMP2.class.getClassLoader ();
  }

  // Note: requires CCTS Schema Module
  @Nonnull
  public static ClassPathResource getXSDResourceUnqualifiedDataTypes ()
  {
    return new ClassPathResource ("/schemas/common/SMP-UnqualifiedDataTypes-2.0.xsd", _getCL ());
  }

  // Note: requires UnqualifiedDataTypes
  @Nonnull
  public static ClassPathResource getXSDResourceQualifiedDataTypes ()
  {
    return new ClassPathResource ("/schemas/common/SMP-QualifiedDataTypes-2.0.xsd", _getCL ());
  }

  // Note: requires QualifiedDataTypes, UnqualifiedDataTypes
  @Nonnull
  public static ClassPathResource getXSDResourceBasicComponents ()
  {
    return new ClassPathResource ("/schemas/common/SMP-BasicComponents-2.0.xsd", _getCL ());
  }

  // Note: requires Xades 1.3.2, Xades 1.4.1
  @Nonnull
  public static ClassPathResource getXSDResourceExtensionContentDataType ()
  {
    return new ClassPathResource ("/schemas/common/SMP-ExtensionContentDataType-2.0.xsd", _getCL ());
  }

  // Note: requires UnqualifiedDataTypes, BasicComponents,
  // ExtensionContentDataType
  @Nonnull
  public static ClassPathResource getXSDResourceExtensionComponents ()
  {
    return new ClassPathResource ("/schemas/common/SMP-ExtensionComponents-2.0.xsd", _getCL ());
  }

  @Nonnull
  public static ClassPathResource getXSDResourcePayloadContentDataType ()
  {
    return new ClassPathResource ("/schemas/common/SMP-PayloadContentDataType-2.0.xsd", _getCL ());
  }

  // Note: requires BasicComponents, ExtensionComponents, PayloadContentDataType
  @Nonnull
  public static ClassPathResource getXSDResourceAggregateComponents ()
  {
    return new ClassPathResource ("/schemas/common/SMP-AggregateComponents-2.0.xsd", _getCL ());
  }

  /**
   * @return A list of all includes in the correct order. Never
   *         <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDIncludes ()
  {
    return new CommonsArrayList <> (CCCTS.getXSDResource (),
                                    getXSDResourceUnqualifiedDataTypes (),
                                    getXSDResourceQualifiedDataTypes (),
                                    getXSDResourceBasicComponents (),
                                    CXMLDSig.getXSDResource (),
                                    CXAdES132.getXSDResource (),
                                    CXAdES141.getXSDResource (),
                                    getXSDResourceExtensionComponents (),
                                    getXSDResourceAggregateComponents ());
  }

  // Note: requires AggregateComponents, BasicComponents, ExtensionComponents,
  // XMLDsig
  @Nonnull
  public static ClassPathResource getXSDResourceServiceGroup ()
  {
    return new ClassPathResource ("/schemas/ServiceGroup-2.0.xsd", _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDResourceServiceGroup ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDResourceServiceGroup ());
    return ret;
  }

  // Note: requires AggregateComponents, BasicComponents, ExtensionComponents,
  // XMLDsig
  @Nonnull
  public static ClassPathResource getXSDResourceServiceMetadata ()
  {
    return new ClassPathResource ("/schemas/ServiceMetadata-2.0.xsd", _getCL ());
  }

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllXSDResourceServiceMetadata ()
  {
    final ICommonsList <ClassPathResource> ret = getAllXSDIncludes ();
    ret.add (getXSDResourceServiceMetadata ());
    return ret;
  }
}
