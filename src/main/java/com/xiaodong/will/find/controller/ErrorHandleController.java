package com.xiaodong.will.find.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 错误处理
 */
abstract class ErrorHandleController {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandleController.class);

    @ExceptionHandler({Throwable.class})
    public String errorHandle(Throwable e) {
        LOG.error("",e);
        return "error";
    }
}
