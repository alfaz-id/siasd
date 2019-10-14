package com.alfazid.siasd.utilities;
/**
 * Created by cigist on 06/07/19.
 */
public class auth {
    public static boolean authRequest(String session){
        if(session !=null){
            return true;
        }else {
            return false;
        }
    }
}
