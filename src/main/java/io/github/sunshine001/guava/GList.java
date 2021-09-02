package io.github.sunshine001.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GList<T> {
    private List<T> list;

    public GList() {
        list = new ArrayList<>();
    }

    public static GList _new() {
        return new GList();
    }

    public GList add(T e) {
        list.add(e);
        return this;
    }

    public GList addAll(Collection<T> newList) {
        list.addAll(newList);
        return this;
    }

    public GList addAll(GList<T> newList) {
        list.addAll(newList.build());
        return this;
    }

    public GList remove(T o) {
        list.remove(o);
        return this;
    }

    public GList remove(int index) {
        list.remove(index);
        return this;
    }

    public GList clear() {
        list.clear();
        return this;
    }

    public int size() {
        return list.size();
    }

    public List<T> build() {
        return list;
    }

    public GList<T> filter(FilterInterface<T> fi) {
        List<T> temp = new ArrayList<>();
        for (T e: list) {
            if (fi.handle(e)) {
                temp.add(e);
            }
        }
        list.clear();
        list.addAll(temp);
        return this;
    }

    public GList<T> map(MapInterface<T> mi) {
        List<T> temp = new ArrayList<>();
        for (T e: list) {
            temp.add(mi.handle(e));
        }
        list.clear();
        list.addAll(temp);
        return this;
    }

    @FunctionalInterface
    public interface FilterInterface<T> {
        boolean handle(T e);
    }

    @FunctionalInterface
    public interface MapInterface<T> {
        T handle(T e);
    }
}
