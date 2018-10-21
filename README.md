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

# News and noteworthy

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
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
