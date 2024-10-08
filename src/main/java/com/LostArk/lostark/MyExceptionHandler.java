package com.LostArk.lostark;

import ch.qos.logback.core.model.processor.ModelHandlerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handler1(){
        return ResponseEntity.status(400).body("에러남");
    }
    // 모든 API에서 에러발생시 대신 실행해줌
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("에러남");
    }
}
