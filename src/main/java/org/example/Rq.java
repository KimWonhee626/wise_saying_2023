package org.example;

import java.util.HashMap;
import java.util.Map;

// request
public class Rq {
    private String actionCode;
    private Map<String, String> params;


    public Rq(String cmd){
        String[] cmdBits = cmd.split("\\?", 2);
        actionCode = cmdBits[0];

        params = new HashMap<>();

        //등록, 목록인 경우
        if(cmdBits.length == 1) return;

        String[] paramBits = cmdBits[1].split("&");

        for(String paramStr : paramBits){
            String[] paramStrBits = paramStr.split("=", 2);

            if (paramStrBits.length == 1) continue;

            String key = paramStrBits[0];
            String value = paramStrBits[1]; // id번호

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String id) {
        return params.get(id);
    }

    public int getIntParam(String id, int defaultValue) {
        try{
            return Integer.parseInt(getParam(id));
        } catch(NumberFormatException e){

        }

        return defaultValue;
    }
}