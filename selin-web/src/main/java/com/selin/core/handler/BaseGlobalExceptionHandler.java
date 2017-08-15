package com.selin.core.handler;


import com.alibaba.fastjson.JSON;
import com.selin.core.exception.SelinException;
import org.roof.spring.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BaseGlobalExceptionHandler {
    protected static final Logger logger = null;
    protected static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";

    protected ModelAndView handleError(HttpServletRequest req, HttpServletResponse rsp, Exception e, String viewName, HttpStatus status) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;
        String errorMsg = e instanceof SelinException ? e.getMessage() : DEFAULT_ERROR_MESSAGE;
        //String errorStack = Throwables.getStackTraceAsString(e);
        //getLogger().error("Request: {} raised {}", req.getRequestURI(), errorStack);
        //if (Ajax.isAjax(req)) {}


        return handleAjaxError(rsp, errorMsg, status);
        //return handleViewError(req.getRequestURL().toString(), errorStack, errorMsg, viewName);
    }

    /*protected ModelAndView handleViewError(String url, String errorStack, String errorMessage, String viewName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", errorStack);
        mav.addObject("url", url);
        mav.addObject("message", errorMessage);
        mav.addObject("timestamp", new Date());
        mav.setViewName(viewName);
        return mav;
    }*/

    protected ModelAndView handleAjaxError(HttpServletResponse rsp, String errorMessage, HttpStatus status) throws IOException {
        rsp.setCharacterEncoding("UTF-8");
        rsp.setContentType("text/html;charset=utf-8");
        rsp.setStatus(status.value());
        PrintWriter writer = rsp.getWriter();
        Result f = new Result(Result.ERROR,errorMessage);
        writer.write(JSON.toJSONString(f));
        writer.flush();
        return null;
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);
    }
}
