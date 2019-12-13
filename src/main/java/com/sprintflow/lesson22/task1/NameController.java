package com.sprintflow.lesson22.task1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/testy")
public class NameController {
    @GetMapping(value = "/test")
    @ResponseBody
    public String showName(@RequestParam("firstName") String firstName) {
        return "Czesc " + firstName + ". Wszystko działa.";
    }
}
