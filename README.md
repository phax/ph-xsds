# ph-xsds

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.helger.xsd/ph-xsds-parent-pom/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.helger.xsd/ph-xsds-parent-pom) 
[![javadoc](https://javadoc.io/badge2/com.helger.xsd/ph-xsds-parent-pom/javadoc.svg)](https://javadoc.io/doc/com.helger.xsd/ph-xsds-parent-pom)
[![CodeCov](https://codecov.io/gh/phax/ph-xsds/branch/master/graph/badge.svg)](https://codecov.io/gh/phax/ph-xsds)

Prebuild JAXB based XSDs referenced in multiple projects.
The projects contained in here are meant to be reusable JAXB objects.
You can use the artefacts as episodes in your projects and therefore reduced code bloat.

Currently contained XSDs are:
* XMLDSig 1.0
* XMLDSig 1.1 (builds on XMLDSig 1.0)
* XAdES 1.3.2 (builds on XMLDSig 1.0) 
* XAdES 1.4.1 (builds on XMLDSig 1.0 and XAdES 1.3.2)
* CCTS CCT SchemaModule
* OASIS BDXR SMP v1 (builds on XMLDSig 1.0) (since v2.2.0)
* OASIS BDXR SMP v2 CS01 (builds on XMLDSig 1.0, XAdES 1.3.2, XAdES 1.4.1 and CCTS CCT SchemaModule) (since v2.2.0)
* XML Encryption Core (builds on XMLDSig 1.0) (since v2.2.4)
* XML Encryption 1.1 (builds on XMLDSig 1.0 and XML Encryption Core) (since v2.2.4)
* XML.xsd 2009-01 (since v2.2.5)
* XLink (build on XML.xsd) (since v2.2.5)
* Web Services Addressing 1.0 (since v2.2.6)

# Maven usage

Add the following to your pom.xml to use this artifact as a BOM, replacing `x.y.z` with the effective version number:

```xml
<dependency>
  <groupId>com.helger.xsd</groupId>
  <artifactId>ph-xsds-parent-pom</artifactId>
  <version>x.y.z</version>
  <type>pom</type>
  <scope>import</scope>
</dependency>
```

Note: prior to v2.3.0 the Maven groupId was `com.helger`.


# Gradle considerations

This project relies on JDK version based Maven profile activation.
See https://github.com/phax/ph-jaxb-pom#gradle-usage for help on this specific issue. 

# News and noteworthy

* v3.0.0 - 2023-01-08
    * Using Java 11 as the baseline
    * Updated to ph-commons 11
    * Using JAXB 4.0 as the baseline
* v2.6.0 - 2021-05-02
    * Updated to ph-commons 10.1
    * Changed the JAXB binding to `XMLOffset*` classes
* v2.5.0 - 2021-03-21
    * Updated to ph-commons 10
    * Changed the JAXB binding to `Offset*` classes
* v2.4.3 - 2021-03-18
    * Updated to ph-commons 9.5.5
    * Changed the JAXB binding for `xs:dateTime` to `java.time.OffsetDateTime`
* v2.4.2 - 2021-02-16
    * Removed dependencies for ph-xmldsig and related - no longer depends on JAXB implementation
* v2.4.1 - 2020-09-17
    * Updated to Jakarta JAXB 2.3.3
* v2.4.0 - 2020-08-28
    * Updated to ph-commons 9.4.7
    * Using Java 8 date and time classes for JAXB created classes
* v2.3.0 - 2020-05-26
    * Changed the "groupId" of the Maven artefacts to `com.helger.xsd`
* v2.2.6 - 2020-05-11
    * Fixed package and class name for the XML XSD handling
    * Added new submodule `ph-xsds-wsaddr` for "Web Services Addressing 1.0"
* v2.2.5 - 2020-05-10
    * Added new submodule `ph-xsds-xml` for "XML.xsd 2009-01"
    * Added new submodule `ph-xsds-xlink` for "XLink"
* v2.2.4 - 2020-03-18
    * Added new submodule `ph-xsds-xmlenc` for "XML Encryption Core"
    * Added new submodule `ph-xsds-xmlenc11` for "XML Encryption 1.1"
* v2.2.3 - 2019-05-28
    * Extended APIs of relevant project to list all necessary includes in the correct order
    * Added namespace URI constants
    * Added default XML namespace prefixes 
* v2.2.2 - 2019-05-06
    * Added a missing piece of Java 12 support
* v2.2.1 - 2019-05-05
    * Added Java 12 support
* v2.2.0 - 2019-05-05
    * Added new submodule `ph-xsds-bdxr-smp1`
    * Added new submodule `ph-xsds-bdxr-smp2`
* v2.1.0 - 2018-11-22
    * Update to ph-commons 9.2.0
* v2.0.1 - 2018-10-22
    * Added utility classes to safely access the contained XSD resources
* v2.0.0 - 2017-11-05
    * Binds to ph-commons 9.0.0
* v1.0.1 - 2017-02-24
    * Binds to ph-commons 8.6.2 - prepared for 9.x
* v1.0.0 - 2016-07-13
    * Binds to ph-commons 8.x

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
It is appreciated if you star the GitHub project if you like it.