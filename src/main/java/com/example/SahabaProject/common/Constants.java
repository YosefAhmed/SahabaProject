package com.example.SahabaProject.common;

import java.util.List;

public class Constants {
    public static String UNKNOWN = "غير معروف";
    public static String NONE = "لا يوجد";

    /**
     * checks if the given object is null or none and return the
     * compatible data status string
     * */
    public static Object checkDataStatus(Object obj){
        if(obj == null){
            return UNKNOWN;
        }
        if(obj instanceof List<?>){
            if(((List<?>) obj).isEmpty()){
                return NONE;
            }
        }
        if (obj instanceof String) {
            if(((String) obj).isEmpty()){
                return NONE;
            }
        }
        return obj;
    }

}
