package io.github.sunshine001.guava;

public class Application {
    public static void main(String[] args) {
        GMap<Object> map = new GMap<>(GMap.ORDER).put("name", "cisco").put("address", 1);
        GList<String> list = new GList<>().add("1").add("2").add("3").filter(e->{
            return e.equals("1");
        }).map(e->{
            return e + "1";
        });
        GString gstring = new GString("123").append("345").append("789");
        Console.log(map.build(), list.build(), gstring.build());

        GMap<String> headers = GMap.n().put("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIiLCJkZXB0X2lkIjotMSwiZXhwIjoxNjMwNzcyNzg3LCJpYXQiOjE2MzA3NjU1ODcsImlzcyI6Imh0aW1lcG9ydGFsIiwianRpIjoiYjI0N2NlNjdjODljNGJhYTk0OWRjZjBhZGNiNzA3YWIiLCJuYmYiOjE2MzA3NjU1ODcsIm9yZyI6IjU1MjA1NDM1MGMwYjQwYTk5NTFiMGI5YjhkZDlhYzZkIiwidHlwZSI6IjgiLCJ1aWQiOiJmMmFkMzU3NmZhNzQ0ODBlOTZhNTU1OWE4ZjZjNGZiYyJ9.cF6SR3CAvtV3t-x9Kl175uTcVrIqS6I3XLHITn6XJzI");
        GResponse response = GPost.n().setUrl("https://new.icity24.xyz/htime/portal/community/menu")
                .setHeaders(headers).exec();
        GResult result = response.result(GResponse.ARRAY);
        Console.log(result.data);
    }

    public static class Result {
        public String code;
        public String message;
        public Object[] data;
    }
}
