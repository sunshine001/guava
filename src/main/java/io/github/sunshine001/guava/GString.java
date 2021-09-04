package io.github.sunshine001.guava;

public class GString {
    private StringBuilder builder;

    public GString() {
        builder = new StringBuilder();
    }

    public GString(String str) {
        builder = new StringBuilder(str);
    }

    public static GString n() {
        return new GString();
    }

    public static GString n(String str) {
        return new GString(str);
    }

    public GString append(String str) {
        builder.append(str);
        return this;
    }

    public GString append(int i) {
        builder.append(i);
        return this;
    }

    public GString append(long l) {
        builder.append(l);
        return this;
    }

    public GString append(float f) {
        builder.append(f);
        return this;
    }

    public String build() {
        return builder.toString();
    }
}
