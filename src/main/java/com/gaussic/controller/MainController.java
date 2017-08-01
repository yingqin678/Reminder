package com.gaussic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
@RequestMapping("/api")
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/{p:.*}", method = RequestMethod.GET)
    public String index(@PathVariable String p) {
        if (p == null || p == "") {
            return "index";
        }

        return p;
    }

    @RequestMapping(value = "/{p:.*}/{v:.*}", method = RequestMethod.GET)
    public String indexB(@PathVariable String p, @PathVariable String v) {
        if (p == null || p == "") {
            return "index";
        }

        return p + "/" + v;
    }
}