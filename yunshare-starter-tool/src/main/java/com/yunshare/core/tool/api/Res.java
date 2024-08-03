package com.yunshare.core.tool.api;

import com.yunshare.core.tool.constant.SysConstant;
import com.yunshare.core.tool.utils.ObjectUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;

/**
 * 统一API响应结果封装
 *
 * @author lzx@yuyuda.com
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description = "返回信息")
public class Res<T> implements Serializable {

    private static final long serialVersionUID = -302303255915939213L;

    @ApiModelProperty(value = "状态码", required = true)
    private int rsCode;
    
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;
    
    @ApiModelProperty(value = "响应数据")
    private T jsonData;
    
    @ApiModelProperty(value = "返回消息", required = true)
    private String rsMsg;

    private Res(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private Res(IResultCode resultCode, String rsMsg) {
        this(resultCode, null, rsMsg);
    }

    private Res(IResultCode resultCode, T jsonData) {
        this(resultCode, jsonData, resultCode.getMessage());
    }

    private Res(IResultCode resultCode, T jsonData, String rsMsg) {
        this(resultCode.getCode(), jsonData, rsMsg);
    }

    private Res(int rsCode, T jsonData, String rsMsg) {
        this.rsCode = rsCode;
        this.jsonData = jsonData;
        this.rsMsg = rsMsg;
        this.success = ResultCode.SUCCESS.code == rsCode;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable Res<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.nullSafeEquals(ResultCode.SUCCESS.code, x.rsCode))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable Res<?> result) {
        return !Res.isSuccess(result);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return Res
     */
    public static <T> Res<T> data(T data) {
        return data(data, SysConstant.DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return Res
     */
    public static <T> Res<T> data(T data, String msg) {
        return data(HttpServletResponse.SC_OK, data, msg);
    }

    /**
     * 返回R
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return Res
     */
    public static <T> Res<T> data(int code, T data, String msg) {
        return new Res<>(code, data, data == null ? SysConstant.DEFAULT_NULL_MESSAGE : msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return Res
     */
    public static <T> Res<T> success(String msg) {
        return new Res<>(ResultCode.SUCCESS, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return Res
     */
    public static <T> Res<T> success(IResultCode resultCode) {
        return new Res<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return Res
     */
    public static <T> Res<T> success(IResultCode resultCode, String msg) {
        return new Res<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return Res
     */
    public static <T> Res<T> fail(String msg) {
        return new Res<>(ResultCode.FAILURE, msg);
    }


    /**
     * 返回R
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return Res
     */
    public static <T> Res<T> fail(int code, String msg) {
        return new Res<>(code, null, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return Res
     */
    public static <T> Res<T> fail(IResultCode resultCode) {
        return new Res<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return Res
     */
    public static <T> Res<T> fail(IResultCode resultCode, String msg) {
        return new Res<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param flag 成功状态
     * @return Res
     */
    public static <T> Res<T> status(boolean flag) {
        return flag ? success(SysConstant.DEFAULT_SUCCESS_MESSAGE) : fail(SysConstant.DEFAULT_FAILURE_MESSAGE);
    }

    /**
     * 返回R
     *
     * @param flag 成功状态 状态为true是同时返回承载数据
     * @param data 承载数据
     * @return Res
     */
    public static <T> Res<T> status(boolean flag, T data) {
        Res<T> result = flag ? success(SysConstant.DEFAULT_SUCCESS_MESSAGE) : fail(SysConstant.DEFAULT_FAILURE_MESSAGE);
        if (flag) {
            result.setJsonData(data);
        }
        return result;
    }
}
