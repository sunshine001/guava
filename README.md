## Summary
Guava is a tool's library for quickly development.

## Repositorie
```
<repositories>
  <repository>
    <id>sonatype</id>
    <url>https://s01.oss.sonatype.org/content/groups/public/</url>
  </repository>
</repositories>
```

## Use
```
<dependency>
  <groupId>io.github.sunshine001</groupId>
  <artifactId>guava</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Deploy
```
mvn clean deploy -P sonatype-oss-release -DskipTests
mvn clean deploy -P sonatype-oss-snapshots -DskipTests
``` 
