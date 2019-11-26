//package com.hp.xyl.svn.controller;
//
//import com.hp.xyl.svn.config.WebSocketServer;
//import com.hp.xyl.svn.model.ResultModel;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/user/")
//public class CheckCenterController {
//
//
//    @GetMapping("/socket/{cid}")
//    public ModelAndView socket(@PathVariable String cid) {
//        ModelAndView mav = new ModelAndView("/index");
//        mav.addObject("cid", cid);
//        return mav;
//    }
//
//    /**
//     * 推送数据接口
//     *
//     * @param cid
//     * @param message
//     * @return
//     * @throws IOException
//     */
//    @ResponseBody
//    @RequestMapping("/socket/push/{cid}")
//    public ResultModel pushToWeb(@PathVariable String cid, String message) throws IOException {
//        ResultModel resultModel = new ResultModel();
//        WebSocketServer.sendInfo(message, cid);
//        return resultModel;
//    }
//}