package com.hp.xyl.svn.exception;

import com.hp.xyl.svn.model.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Author:xyl
 * Date:2019/2/1 16:35
 * Description:全局异常处理
 */
@ControllerAdvice
@Slf4j
public class SysExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultModel handle(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(-1);
        resultModel.setMessage(e.getMessage());
        return resultModel;
    }
}
