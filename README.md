# Hangar Wrapper

A Java/Kotlin wrapper for PaperMC's [Hangar API](https://hangar.papermc.io/api-docs).

## How to Use

All methods in the wrapper should be accessed through the ```HangarClient``` class.

It currently supports retrieving information about projects, versions and users. 

The following methods are in the ```HangarClient``` class, and can be accessed statically:

### Projects

```kt
Projects getProjects(boolean orderWithRelevance, int limit, int offset)

Project getProject(String author, String slug)

int getTotalProjectCount()
```

### Versions
```kt
Versions getVersions(String author, String slug)

Version getVersion(String author, String slug, String version)

String getDownloadURL(String author, String slug, String version, Platform platform)
```
### Users
```kt
User getUser(String user)
```

## Installation

The latest version can be found in the releases tab on the right.

### Maven  
```xml
<repository>
    <id>flyte-repository</id>
    <name>Flyte Repository</name>
    <url>https://repo.flyte.gg/<repository></url>
</repository>
```  
```xml
<dependency>
    <groupId>gg.flyte</groupId>
    <artifactId>hangarWrapper</artifactId>
    <version>VERSION</version>
</dependency>
```

#### Gradle
```kt
repositories {
    maven ("https://repo.flyte.gg/releases")
}
        
dependencies {
    implementation("gg.flyte:hangarWrapper:VERSION")
}
```  

## Contributing

Contributions are always welcome. Please open a pull request and try to maintain a similar code quality and style. The team at [Flyte](https://flyte.gg) is working on supporting new endpoints and keeping up with Hangar's changing API.

If you have no coding knowledge you can contribute by raising an issue.

## Author

This framework was made as an open source tool for [Flyte](https://flyte.gg) and the wider community.

- Created by [Dawson (dawsson)](https://github.com/Dawsson)
