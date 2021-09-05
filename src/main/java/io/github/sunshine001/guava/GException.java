package io.github.sunshine001.guava;

import java.util.LinkedHashMap;
import java.util.Map;

public class GException extends Exception {
    private final String code;
    private final String message;

    public GException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public static GException n(String code, String message) {
        return new GException(code, message);
    }

    public Map<String, String> build() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("message", message);
        return map;
    }
}
