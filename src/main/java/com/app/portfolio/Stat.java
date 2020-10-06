package com.app.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
    private Long solved;
    public Stat(){}

    public Long getSolved() {
        return solved;
    }

    public void setSolved(Long solved) {
        this.solved = solved;
    }
}
