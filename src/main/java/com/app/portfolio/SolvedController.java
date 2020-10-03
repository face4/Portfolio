package com.app.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Controller
public class SolvedController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.url.yukicoder}")
    private String Url;

    @GetMapping("/solved")
    public String solved(Model model){
        Object obj = restTemplate.getForObject(Url, Object.class);
        LinkedHashMap<Object, Object> lhm = (LinkedHashMap)obj;
        model.addAttribute("solved", lhm.get("Solved"));
        return "index";
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}