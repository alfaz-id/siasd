package com.alfazid.siasd.utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Random;
import java.util.Date;

/**
 * Created by cigist on 06/07/19.
 */
public class StringUtilities {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Timestamp getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }

    public static String genToken() {
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();

        return token;
    }

    Random rand = new Random();
    StringBuilder sBuildz = new StringBuilder();
    int number;
    StringBuilder sb = new StringBuilder();

    public static String formatApostrophe(String value) {
        return null;
    }

    public String autoCode(String formatKey) {
        number = rand.nextInt(999999) + 999999;
        sBuildz.setLength(0);
        String code = sBuildz.append(formatKey).append(number).toString();

        return code;

    }
    public String activCode() {
        number = rand.nextInt(9999) + 9999;
        sBuildz.setLength(0);
        String code = sBuildz.append(number).toString();

        return code;

    }
    public static String getDateTimeNow(String pattern) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String strDate = formatter.format(date);

        return strDate;
    }
}