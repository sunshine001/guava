package io.github.sunshine001.guava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GMap<T> {
    private Map<String, T> map;

    public static final GMapType HASH = GMapType.HASH;
    public static final GMapType ORDER = GMapType.ORDER;

    public GMap() {
        map = new HashMap<>();
    }

    public GMap(GMapType type) {
        if (type == ORDER) {
            map = new LinkedHashMap<>();
        } else {
            map = new HashMap<>();
        }
    }

    public static GMap n() {
        return new GMap();
    }

    public static GMap n(GMapType type) {
        return new GMap(type);
    }

    public GMap put(String key, T value) {
        map.put(key, value);
        return this;
    }

    public GMap put(Map<String, T> newMap) {
        map.putAll(newMap);
        return this;
    }

    public GMap put(GMap<T> newMap) {
        put(newMap.build());
        return this;
    }

    public T get(String key) {
        return map.get(key);
    }

    public GMap remove(String key) {
        map.remove(key);
        return this;
    }

    public GMap clear() {
        map.clear();
        return this;
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }

    public Map<String, T> build() {
        return map;
    }

    private enum GMapType {
        HASH, ORDER
    }
}
