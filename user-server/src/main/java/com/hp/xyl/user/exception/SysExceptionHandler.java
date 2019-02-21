package com.hp.xyl.user.exception;

import com.hp.xyl.user.model.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
        log.error(e.getMessage());
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(-1);
        resultModel.setMessage(e.getMessage());
        return resultModel;
    }
}
