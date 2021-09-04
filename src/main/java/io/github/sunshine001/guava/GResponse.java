package io.github.sunshine001.guava;

import net.sf.json.JSONObject;

public class GResponse<T> {
    public final int code;
    public final String message;
    public final String data;

    public static final ObjectType OBJECT = ObjectType.OBJECT;
    public static final ObjectType ARRAY = ObjectType.ARRAY;

    public GResponse(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JSONObject json() {
        return JSONObject.fromObject(data);
    }

    public T json(JSONInterface<T> ji) {
        JSONObject json = JSONObject.fromObject(data);
        return ji.handle(json);
    }

    public GResult result(ObjectType type) {
        JSONObject json = JSONObject.fromObject(data);
        return new GResult(json.getString("code"),
                json.getString("message"),
                type == ObjectType.ARRAY ?
                        json.getJSONArray("data") : json.getJSONObject("data"));
    }

    public String toString() {
        return new StringBuilder().append("code=").append(code)
                .append(", message=").append(message)
                .append(", data=").append(data).toString();
    }

    @FunctionalInterface
    public interface JSONInterface<T> {
        T handle(JSONObject json);
    }

    public enum ObjectType {
        OBJECT, ARRAY
    }
}
