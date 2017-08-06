package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
@RequestMapping("/portal")
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "item/item";
    }

    @RequestMapping(value = "/{p:.*}", method = RequestMethod.GET)
    public String index(@PathVariable String p) {
        if (p == null || p == "") {
            return "item/item";
        }

        return p + "/" + p;
    }

    @RequestMapping(value = "/{p:.*}/{v:.*}", method = RequestMethod.GET)
    public String indexB(@PathVariable String p, @PathVariable String v) {
        if (p == null || p == "") {
            return "index";
        }

        return p + "/" + v + "/" + v;
    }
}