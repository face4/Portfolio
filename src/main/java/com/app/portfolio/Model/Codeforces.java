package com.app.portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Codeforces {
    private String status;
    private List<Submission> result;

    public Codeforces(){
        result = new ArrayList<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Submission> getResult() {
        return result;
    }

    public void setResult(List<Submission> result) {
        this.result = result;
    }

    public int getSolved(){
        HashSet<String> solved = new HashSet<>();
        result.stream().filter(sub->sub.getVerdict().equals("OK"))
                .forEach(sub->solved.add(sub.getProblem().toString()));
        return solved.size();
    }

    @Override
    public String toString(){
        return status + ":" + result.size();
    }
}
