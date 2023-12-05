package com.my.app.exception;


import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;


@RestControllerAdvice
public class MyAppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Throwable e) {
        e.printStackTrace();

        if (e instanceof MethodArgumentNotValidException appException) {
            List<ObjectError> allErrors = appException.getBindingResult().getAllErrors();
            ObjectError objectError = allErrors.stream().findFirst().get();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 100001);
            jsonObject.put("message", objectError.getDefaultMessage());
            String r = jsonObject.toString();
            return new ResponseEntity<>(r, HttpStatus.OK);
        }else if(e instanceof HandlerMethodValidationException appException){

        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", -1);
        jsonObject.put("message", "未知异常,请联系管理员");
        String r = jsonObject.toString();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
