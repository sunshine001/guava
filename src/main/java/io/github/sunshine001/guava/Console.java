package io.github.sunshine001.guava;

/**
 * package println for quickly development
 */
public class Console {
    private static boolean isOn = true;

    public static void on() {
        isOn = true;
    }

    public static void off() {
        isOn = false;
    }

    public static void log(Object ...args) {
        if (!isOn) return;

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
