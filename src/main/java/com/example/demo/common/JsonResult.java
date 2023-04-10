package com.example.demo.common;

import lombok.Data;

@Data
public class JsonResult<T> {

    private T data;
    private Integer code;
    private String msg;

    /**
     * 若没有数据返回，默认状态码为200，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = 200;
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为200，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为200，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = 200;
        this.msg = msg;
    }

    public JsonResult( Integer code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 省略get和set方法
}