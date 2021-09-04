## Summary
Guava is a tool's library for quickly development.

## Deploy
```
mvn clean deploy -P sonatype-oss-release -DskipTests
mvn clean deploy -P sonatype-oss-snapshots -DskipTests
``` 

## Repositorie
```
<repositories>
  <repository>
    <id>sonatype</id>
    <url>https://s01.oss.sonatype.org/content/groups/public/</url>
  </repository>
</repositories>
```

## Dependency
```
<dependency>
  <groupId>io.github.sunshine001</groupId>
  <artifactId>guava</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Use
#### GMap
```
GMap<Object> m = GMap.n().put("name", "cisco").put("address", 1);
```
#### GList
```
GList<String> list = new GList<>().add("1").add("2").filter(e->{
        return e.equals("1");
    }).map(e->{
        return e + "1";
    });
```
#### GString
```
GString gstring = new GString("123").append("345").append("789");
```
#### GPost
```
GResponse response = GPost.n().setUrl("https://www.test.com")
                .setHeaders(headers).exec();
GResult result = response.result(GResponse.ARRAY);
```
```
GResponse<Result> response = GPost.n().setUrl("http://www.test.com")
                .setHeaders(headers).setBody(body).exec();
Result result = response.json(r->{
    Result rst = new Result();
    rst.code = r.getString("code");
    rst.data = r.getJSONArray("data").toArray();
    return rst;
});
```
