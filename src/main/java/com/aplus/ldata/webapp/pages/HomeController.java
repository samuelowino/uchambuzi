package com.aplus.ldata.webapp.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    Logger LOGGER = LoggerFactory.getLogger(HomeController.class.getSimpleName());

    @RequestMapping(value = "/home")
    public String index(Model model){
        LOGGER.info("Load analytics home page...");
        model.addAttribute("message", "Hello Wild...");
        return "home";
    }
}
