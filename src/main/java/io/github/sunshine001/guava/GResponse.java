package io.github.sunshine001.guava;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GResponse<T> {
    public final int code;
    public final String message;
    public final String data;

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

    public GResult result() {
        JSONObject json = JSONObject.fromObject(data);
        return new GResult(json.getString("code"),
                json.getString("message"),
                dimParse(json));
    }

    private Object dimParse(JSONObject json) {
        Object rst = toObject(json);
        if (rst == null) {
            rst = toArray(json);
        }
        return rst;
    }

    private JSONArray toArray(JSONObject json) {
        try {
            return json.getJSONArray("data");
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject toObject(JSONObject json) {
        try {
            return json.getJSONObject("data");
        } catch (Exception e) {
            return null;
        }
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
}
