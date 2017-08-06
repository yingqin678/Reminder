package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "item/item";
    }

    @RequestMapping(value = "/{p:.*}", method = RequestMethod.GET)
    public String indexApi() {
            return "item/item";
    }

}