package com.app.portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String user_id;
    private Long problem_count;

    public User(){}

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getProblem_count() {
        return problem_count;
    }

    public void setProblem_count(Long problem_count) {
        this.problem_count = problem_count;
    }

    @Override
    public String toString(){
        return user_id + " : " + problem_count;
    }
}
