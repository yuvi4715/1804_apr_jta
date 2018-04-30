package com.hpark12.request;

import com.hpark12.delegate.HomeController;
import com.hpark12.delegate.LoginController;

import javax.servlet.http.HttpServletRequest;

import com.hpark12.util.logUtil;


public class RequestHelper {


    static String process(HttpServletRequest req) {
        logUtil.log.info(req.getRequestURI());
        switch(req.getRequestURI()){
            case "/html/login.do":
                return LoginController.login(req);
            case "/html/home.do":
                return HomeController.home(req);
            default:
                return "html/FailedLogin.html";
        }
    }


}
