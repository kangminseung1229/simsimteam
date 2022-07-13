package com.example.team.simsim.team;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.websocket.Endpoint;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class testController {

    private final ObjectMapper objectMapper;

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @PostMapping("/team")
    @ResponseBody
    public String team(@RequestBody List<nickname> data, @RequestParam(name = "cnt") String cnt) throws ParseException {

        String returnValue = "";
        int endP = Integer.parseInt(cnt);
        int i = 0;
        int teamIDX = 1;
        try {
            Collections.shuffle(data);

            returnValue += "<span id=\"resultValue\">";

            for (nickname nickname : data) {

                returnValue += "<button type=\"button\" class=\"btn btn-info\">" + nickname.getValue() + "</button>"
                        + "&#9;";
                i++;

                if (endP == i) {
                    returnValue += "---------> <b class='team'>" + teamIDX++ + "팀</b> <Br/><Br/><Br/>";
                    i = 0;
                }

            }

            returnValue += "</span>";

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // API를 통해 넘어온 JSON을 파싱

        return returnValue;

    }
}
