## Summary
Guava is a tool's library for quickly development.

## Deploy
```
mvn clean deploy -P sonatype-oss-release -DskipTests
mvn clean deploy -P sonatype-oss-snapshots -DskipTests
``` 

## Settings
```
<servers>
  <server>
    <id>sonatype-oss-snapshots</id>
    <username>username</username>
    <password>password</password>
  </server>
  <server>
    <id>sonatype-oss-staging</id>
    <username>username</username>
    <password>password</password>
  </server>
</servers>
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
  <version>1.0.1</version>
</dependency>
```

## Use
#### Console
````
Console.log(1, "2", list, map)
````
#### GMap
```
GMap<Object> m = new GMap().put("name", "cisco").put("address", 1);
Map<String, Object> result = m.build();
```
```
GMap<Object> m = GMap.n().put("name", "cisco").put("address", 1);
Map<String, Object> result = m.build();
```
#### GList
```
GList<String> list = new GList<>().add("1").add("2").filter(e->{
    return e.equals("1");
}).map(e->{
    return e + "1";
});
List<String> result = list.build();
```
#### GString
```
GString gstring = new GString("123").append("345").append("789");
```
#### GPost
```
GMap<String> headers = new GMap<>();
GMap<String> body = new GMap<>();
GResponse response = new GPost().setUrl("https://www.test.com")
    .setHeaders(headers).setBody(body).exec();
GResult<JSONArray> result = response.result();
```
```
GResponse<Result> response = GPost.n().setUrl("http://www.test.com")
    addHeader(key, value).addBody(key, value).exec();
Result result = response.json(r->{
    Result rst = new Result();
    rst.code = r.getString("code");
    rst.data = r.getJSONArray("data").toArray();
    return rst;
});
```
#### GException
```
try {
    throw new GException("0001", "failure");
} catch (GException ge) {
    Console.log(ge.build());
}
```
