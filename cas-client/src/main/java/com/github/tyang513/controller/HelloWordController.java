package com.github.tyang513.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tao.yang
 * @date 2018-05-23
 */

@Controller
@RequestMapping("/")
public class HelloWordController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(HelloWordController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        logger.info("index");
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        logger.info("hello world");
        return "hello world";
    }


}
