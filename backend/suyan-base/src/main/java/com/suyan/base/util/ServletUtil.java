package com.suyan.base.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class ServletUtil {

    public static HttpServletRequest getRequest() {
        return RequestContextHolder.currentRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return RequestContextHolder.getRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        HttpSession session = request == null ? null : request.getSession();
        return session;
    }


    public static Map<String, String> getRequestMap() {
        Map<String, String> map = new HashMap<>();
        HttpServletRequest request = ServletUtil.getRequest();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            map.put(headerName, request.getHeader(headerName));
        }
        return map;
    }

}
