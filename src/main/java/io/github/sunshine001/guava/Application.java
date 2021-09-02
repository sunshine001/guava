package io.github.sunshine001.guava;

public class Application {
    public static void main(String[] args) {
        GMap<Object> map = new GMap<>(GMap.ORDER).put("name", "cisco").put("address", 1);
        GList<String> list = new GList<>().add("1").add("2").add("3").filter(e->{
            return e.equals("1");
        }).map(e->{
            return e + "1";
        });
        Console.log(map.build(), list.build());
    }
}
