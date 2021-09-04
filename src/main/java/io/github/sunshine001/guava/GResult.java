package io.github.sunshine001.guava;

public class GResult<T> {
    public final String code;
    public final String message;
    public final T data;

    public GResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
