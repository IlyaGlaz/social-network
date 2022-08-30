package org.glaz.network.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice(basePackages = "org.glaz.network.http.controller")
public class ControllerExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public String handleExceptions(Exception exception, HttpServletRequest request) {
//        log.error("Failed to return response", exception);
//        return "error/error500";
//    }
}
