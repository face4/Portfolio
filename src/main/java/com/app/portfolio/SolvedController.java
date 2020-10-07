package com.app.portfolio;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class SolvedController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.url.yukicoder}")
    private String yukiUrl;

    @Value("${api.url.atcoder}")
    private String acUrl;

    @Value("${api.url.codeforces}")
    private String cfUrl;

    @Value("${api.url.aoj}")
    private String aojUrl;

    @GetMapping("/")
    public String solved(Model model){
        Object obj = restTemplate.getForObject(yukiUrl, Object.class);
        LinkedHashMap<Object, Object> lhm = (LinkedHashMap)obj;
        model.addAttribute("yukisolved", lhm.get("Solved"));
        try {
            Codeforces codeforces = restTemplate.getForObject(cfUrl, Codeforces.class);
            model.addAttribute("codeforcessolved", codeforces.getSolved());
        }catch(Exception e){
            model.addAttribute("codeforcessolved", "It seems that Codeforces is temporally unavailable");
        }
        List<User> atcoder = Arrays.asList(restTemplate.getForObject(acUrl, User[].class));
        atcoder.stream().filter(it->it.getUser_id().equals("face4")).forEach(it->model.addAttribute("atcodersolved", it.getProblem_count()));
        Aoj aoj = restTemplate.getForObject(aojUrl, Aoj.class);
        model.addAttribute("aojsolved", aoj.getStatus().getSolved());
        return "index";
    }

    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        clientHttpRequestFactory.setConnectTimeout(2000);
        return new RestTemplate(clientHttpRequestFactory);
    }
}