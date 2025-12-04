package com.suyan.base.web;

import com.suyan.base.util.ServletUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class CommonController {

    public HttpServletRequest getRequest() {
        return ServletUtil.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletUtil.getResponse();
    }

    public HttpSession getSession() {
        return ServletUtil.getSession();
    }

    protected Map<String, String> getRequestMap() {
        Map<String, String> map = new HashMap<>();
        HttpServletRequest request = getRequest();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            map.put(headerName, request.getHeader(headerName));
        }
        return map;
    }

}
