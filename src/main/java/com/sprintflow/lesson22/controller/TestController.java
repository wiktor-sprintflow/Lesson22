package com.sprintflow.lesson22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/start")
public class TestController {
    // Przy GetMapping nie potrzeba method. GetMapping i PostMapping, to analogia do doGet i doPost w servletach
    @GetMapping(value = "/hello")
    @ResponseBody  //z response body zwraca string a z metody.
    public String hello(HttpServletRequest httpServletRequest) {
        String firstName = httpServletRequest.getParameter("firstName");
        String host = httpServletRequest.getHeader("Host");
        String remoteAddr = httpServletRequest.getRemoteAddr();
        return "Witaj " + firstName + ", Host " + host + " IP: " + remoteAddr;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public void hello2() {
        System.out.println("Hello Spring 2");
    }

    @GetMapping(value = "/view")  //Bez response body szuka htmla w static
    public String hello3() {

        return "redirect:/start/hello";
        //return "/example.html";
        //return "redirect:/example.html";
    }

    @GetMapping(value = "/hello/spring")
    @ResponseBody  //z response body zwraca string a z metody.
    public String helloSpring(@RequestParam("firstName") String firstName) {

        return "Witaj " + firstName;
    }

}
