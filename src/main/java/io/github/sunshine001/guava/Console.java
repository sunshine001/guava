package io.github.sunshine001.guava;

public class Console {
    public static void log(Object ...args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                sb.append(" " + args[i]);
            } else {
                sb.append(args[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
