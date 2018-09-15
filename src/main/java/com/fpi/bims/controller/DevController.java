package com.fpi.bims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@Controller
@RequestMapping(value = "/")
public class DevController {

    private static final Logger logger = LoggerFactory.getLogger(DevController.class);

    @RequestMapping(value = "/dev", method = RequestMethod.GET)
    public String devsupport(){
        logger.info("devsupport swagger-ui");
        return "redirect:/swagger-ui.html";
    }
}
