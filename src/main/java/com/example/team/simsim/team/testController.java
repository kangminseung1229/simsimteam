package com.example.team.simsim.team;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class testController {
    

    @GetMapping("/")
    public String start(){
        return "start";
    }


    @PostMapping("/team")
    @ResponseBody
    public String team(@RequestBody List<String> data){

        return data.toString();

    }
    
}
