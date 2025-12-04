package com.suyan.base.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Schema(description = "请求结果")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "结果代码")
    private Integer code = ResultCode.SUCCESS.code;
    @Schema(description = "错误说明")
    private String message = "";
    @Schema(description = "结果对象")
    private T data;
    @Schema(description = "操作标识")
    private Boolean success = Boolean.TRUE;
    @Schema(description = "当前时间戳")
    private Long timestamp;

    public Result(int code, String message, boolean success, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(success);
        this.setData(data);
    }

    public Result(int code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(code == 200);
        this.setData(data);
    }

    /**
     * 构建成功对象实例
     */
    public static <T> Result<T> success() {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, null);
    }

    public static <T> Result<T> success(T value) {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, value);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(ResultCode.SUCCESS.code, message, true, data);
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<T>(ResultCode.COMMON_MESSAGE.code, message, false, null);
        return result;
    }

    /**
     * 构建错误对象
     */
    public static <T> Result<T> error(ResultCode errorCode) {
        return new Result<T>(errorCode.code, errorCode.desc, false, null);
    }

    public static <T> Result<T> error(int code, String message, Object... args) {
        Result<T> r = new Result<T>(code, "", false, null);
        r.setFormatMessage(message, args);
        return r;
    }

    public static <T> Result<T> error(ResultCode resultCode, Object... args) {
        Result<T> r = new Result<T>(resultCode.getCode(), "", false, null);
        r.setFormatMessage(resultCode.getDesc(), args);

        return r;
    }

    /**
     * 设置错误编码
     */
    public Result<T> setErrorCode(ResultCode errorCode) {
        if (errorCode == null) {
            return null;
        }

        this.code = errorCode.code;
        this.message = errorCode.desc;
        this.success = false;
        return this;
    }

    /**
     * 设置错误编码
     *
     * @param errorCode
     * @param args
     * @return
     */
    public Result<T> setErrorCode(ResultCode errorCode, Object... args) {
        if (errorCode == null) {
            return null;
        }

        this.code = errorCode.code;
        setFormatMessage(errorCode.getDesc(), args);
        this.success = false;
        return this;
    }

    public void setMessageStatus(ResultCode resultCode, Object... args) {
        setCode(resultCode.getCode());
        setFormatMessage(resultCode.getDesc(), args);
    }

    public void setFormatMessage(String message, Object... args) {
        if (args == null || args.length == 0) {
            this.setMessage(message);
        } else {
            this.setMessage(String.format(message, args));
        }
    }

    public Long getTimestamp() {
        return timestamp == null ? System.currentTimeMillis() : timestamp;
    }

}
