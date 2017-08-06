package com.humtk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 6.08.2017.
 */

@RestController
public class RequestController {
    @RequestMapping("/ogretmen")
    public String getIndex() {
        return "burcuuuuuu";
    }
}
