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

            String key = paramStrBits[0]; // id=value에서 "id" 들어감
            String value = paramStrBits[1]; // id=value에서 "value" 들어감

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try{
            return Integer.parseInt(getParam(name));
        } catch(NumberFormatException e){

        }

        return defaultValue;
    }
}
