package io.github.sunshine001.guava;

/**
 * package println for quickly development
 */
public class Console {
    /**
     * normal print
     * @param args
     */
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
