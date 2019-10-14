package com.alfazid.siasd.utilities;

/**
 * Created by cigist on 06/07/19.
 */
public class Pagination {
    public static int currentPage(String current){
        if(current ==null || current.isEmpty()){
            return 0;
        }else{
            return Integer.parseInt(current);
        }
    }
    public static int recordsPerPage(String record){
        if(record ==null || record.isEmpty()){
            return 10;
        }else{
            return Integer.parseInt(record);
        }
    }
    public static String getColumn(String columnName,String column){
        if(column==null || column.isEmpty()){
            return columnName;
        }else{
            return column;
        }
    }
    public static String getValue(String value){
        if(value ==null || value.isEmpty()){
            return "";
        }else{
            return value;
        }
    }
}

