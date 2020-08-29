package kz.fibonaccis.fbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/")
public class MainController {


    @GetMapping(value = "")
    public String index(){

        return "index";
    }



}
