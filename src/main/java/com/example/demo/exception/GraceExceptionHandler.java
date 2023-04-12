package com.example.demo.exception;

import com.example.demo.common.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GraceExceptionHandler {
    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public JsonResult returnMaxFileSizeLimit(FileSizeLimitExceededException e){
        return new JsonResult<String>(400,"文件大小不能超过100KB","{}");
    }
}
