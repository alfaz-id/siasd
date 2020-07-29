package com.alfazid.siasd.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by cigist on 23/07/20.
 */
public class CommonUtil {
    private CommonUtil(){

    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String generateyyyyMMdd(){
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    public static String generateddMMyyyy(){
        return (new SimpleDateFormat("dd-MM-yyyy")).format(new Date());
    }
}
