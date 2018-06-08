package com.github.tyang513.controller;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() throws Exception {
        return "hello world";
    }
}
