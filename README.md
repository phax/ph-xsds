# ph-xsds

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8f026db5f326450e8f1726f1160a9085)](https://www.codacy.com/app/philip/ph-xsds?utm_source=github.com&utm_medium=referral&utm_content=phax/ph-xsds&utm_campaign=badger)

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

Add the following to your pom.xml to use this artifact as a BOM (replacing `x.y.z` with the real version number):

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

* v2.4.0 - work in progress
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
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a> |
Kindly supported by [YourKit Java Profiler](https://www.yourkit.com)