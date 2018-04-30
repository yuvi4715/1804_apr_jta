package com.hpark12.ajax;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AjaxServlet extends HttpServlet {

    private static final long serialVersionUID = 590444879370100299L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().write(AjaxRequestHelper.process(req, resp));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().write(AjaxRequestHelper.process(req, resp));
    }
}
