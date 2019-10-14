package com.alfazid.siasd.utilities;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by cigist on 06/07/19.
 */
public class AppLog {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void ddlSQL(String SQL){
        System.out.println(ANSI_YELLOW +"SQL_QUERY ______ ");
        System.out.println("");
        System.out.println(ANSI_YELLOW +" "+SQL);
        System.out.println(ANSI_YELLOW +"________________ ");
    }
    public  static void doLog(String erroLog){
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./src/AppLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(erroLog);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
