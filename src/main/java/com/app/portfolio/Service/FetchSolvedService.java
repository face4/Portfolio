package com.app.portfolio.Service;

import com.app.portfolio.Model.Aoj;
import com.app.portfolio.Model.Codeforces;
import com.app.portfolio.Model.User;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class FetchSolvedService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url.yukicoder}")
    private String yukiUrl;

    @Value("${api.url.atcoder}")
    private String acUrl;

    @Value("${api.url.codeforces}")
    private String cfUrl;

    @Value("${api.url.aoj}")
    private String aojUrl;

    public int getYukicoderSolved(){
        Object obj = restTemplate.getForObject(yukiUrl, Object.class);
        LinkedHashMap<Object, Object> lhm = (LinkedHashMap)obj;
        return (Integer)lhm.get("Solved");
    }

    public long getCodeforcesSolved(){
        try {
            Codeforces codeforces = restTemplate.getForObject(cfUrl, Codeforces.class);
            return codeforces.getSolved();
        }catch(Exception e){
            return 0;
        }
    }

    public long getAtCoderSolved(){
        List<User> atcoder = Arrays.asList(restTemplate.getForObject(acUrl, User[].class));
        for(User user : atcoder){
            if(user.getUser_id().equals("face4")){
                return user.getProblem_count();
            }
        }
        return 0;
    }

    public long getAojSolved(){
        Aoj aoj = restTemplate.getForObject(aojUrl, Aoj.class);
        return aoj.getStatus().getSolved();
    }

    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        clientHttpRequestFactory.setConnectTimeout(2000);
        return new RestTemplate(clientHttpRequestFactory);
    }
}
