package com.suyan.base.exception;

import cn.hutool.core.util.StrUtil;
import com.suyan.base.domain.ResultCode;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static Map<Integer, String> SERVICE_EXCEPTION_MAP = null;
    private static Map<Integer, String> SERVICE_EXCEPTION_EN_MAP = null;
    private static final String SERVICE_EXCEPTION_FILE = "META-INF/exception_def.properties";
    private static final String SERVICE_EXCEPTION_EN_FILE = "META-INF/exception_en.properties";
    /**
     * 异常错误代码
     */
    private Integer code;
    /**
     * 异常错误信息
     */
    private String message;

    public ServiceException(Integer code) {
        this.code = code;
        this.message = matchMessage(code);
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
        if (this.message == null || "".equals(this.message)) {
            this.message = matchMessage(code);
        }
    }

    public ServiceException(Integer code, String message, Object... args) {
        super(message);
        this.code = code;
        if (args == null || args.length == 0) {
            this.message = message;
        } else {
            this.message = String.format(message, args);
        }
    }

    public ServiceException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getDesc());
    }

    public ServiceException(ResultCode resultCode, Object... args) {
        this(resultCode.getCode(), resultCode.getDesc(), args);
    }

    private synchronized void loadExceptionDef() {
        log.info("load exception definition");
        SERVICE_EXCEPTION_MAP = new ConcurrentHashMap<>();
        SERVICE_EXCEPTION_EN_MAP = new ConcurrentHashMap<>();
        try {
            extracted(SERVICE_EXCEPTION_FILE, SERVICE_EXCEPTION_MAP);
            extracted(SERVICE_EXCEPTION_EN_FILE, SERVICE_EXCEPTION_EN_MAP);
        } catch (IOException e) {
            log.error("load exception definition error", e);
        }

        log.info("all service exception {}", SERVICE_EXCEPTION_MAP);
        log.info("all service en exception {}", SERVICE_EXCEPTION_MAP);
    }

    private static void extracted(String file, Map<Integer, String> map) throws IOException {
        Enumeration<URL> exceptionDefs = ClassLoader.getSystemResources(file);
        while (exceptionDefs.hasMoreElements()) {
            URL exceptionDef = exceptionDefs.nextElement();

            log.info("load exception definition from {}", exceptionDef);

            InputStream in = new BufferedInputStream(exceptionDef.openStream());
            Properties properties = new Properties();
            properties.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            for (String name : properties.stringPropertyNames()) {
                Integer eCode = null;
                try {
                    eCode = Integer.valueOf(name);
                } catch (Exception e) {
                    log.warn("{} not a int code!", name);
                }
                if (eCode != null) {
                    map.put(eCode, properties.getProperty(name));
                }
            }
        }
    }

    public String matchMessage(Integer code) {
        if (SERVICE_EXCEPTION_MAP == null || SERVICE_EXCEPTION_EN_MAP == null) {
            loadExceptionDef();
        }
        String msg = SERVICE_EXCEPTION_MAP.get(code);
        if (StrUtil.isEmpty(msg)) {
            log.warn("undefined exception message! code = {}", code);
            msg = "undefined exception message!";
        }
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

        if ("".equals(this.message) || this.message == null) {
            this.message = matchMessage(code);
        }
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        this.code = ResultCode.COMMON_MESSAGE.getCode();
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
