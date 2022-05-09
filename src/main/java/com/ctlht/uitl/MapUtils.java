package com.ctlht.uitl;

import java.util.Map;

public class MapUtils {
    public static <T> T getObject(Map<String,Object> params, String key, Class<T> tClass) {
        Object obj = params.get(key); //params.getOrDefault(key,null);
        if(obj == null) return null;

        if(tClass.getTypeName().equals("java.lang.Long")) {
            obj = Long.valueOf(obj.toString());
        }
        if(tClass.getTypeName().equals("java.lang.Integer")) {
            obj = Integer.valueOf(obj.toString());
        }
        if(tClass.getTypeName().equals("java.lang.Double")) {
            obj = Double.valueOf(obj.toString());
        }
        if(tClass.getTypeName().equals("java.lang.String")) {
            obj = (obj.toString().equals("") ?  null :obj.toString());
        }
        return tClass.cast(obj);
    }
}