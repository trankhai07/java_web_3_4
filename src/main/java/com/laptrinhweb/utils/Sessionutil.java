package com.laptrinhweb.utils;

import javax.servlet.http.HttpServletRequest;

public class Sessionutil {
    private static Sessionutil sessionutil =  null;
    public static Sessionutil getInstance(){
        if(sessionutil == null)
        {
            sessionutil = new Sessionutil();
        }
        return sessionutil;
    }
    public void putValue(HttpServletRequest request,String key,Object value){
          request.getSession().setAttribute(key,value);
    }
    public Object getValue(HttpServletRequest request,String key){
        return request.getSession().getAttribute(key);
    }
    public void removeValue(HttpServletRequest request,String key){
        request.getSession().removeAttribute(key);
    }
}
