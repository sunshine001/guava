package io.github.sunshine001.guava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GDate {
    public static final GDateType YYYY_MM_DD_HH_MM_SS = GDateType.YYYY_MM_DD_HH_MM_SS;
    public static final GDateType YYYY_MM_DD_HH_MM = GDateType.YYYY_MM_DD_HH_MM;
    public static final GDateType YYYY_MM_DD = GDateType.YYYY_MM_DD;

    private long time = -1;
    private String timeStr;

    public GDate(long time) {
        this.time = time;
    }

    public GDate(String date) {
        this.timeStr = date;
    }

    public String format(GDateType type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type.getDescription());
        if (this.time > -1) {
            Date date = new Date();
            date.setTime(this.time);
            return sdf.format(date);
        } else {
            try {
                return sdf.format(sdf.parse(this.timeStr));
            } catch (ParseException e) {
                return null;
            }
        }
    }

    private enum GDateType {
        YYYY_MM_DD_HH_MM_SS {
            public String getDescription() {
                return "yyyy-MM-dd HH:mm:ss";
            }
        },
        YYYY_MM_DD_HH_MM {
            public String getDescription() {
                return "yyyy-MM-dd HH:mm";
            }
        },
        YYYY_MM_DD {
            public String getDescription() {
                return "yyyy-MM-dd";
            }
        };
        public abstract String getDescription();
    }
}
