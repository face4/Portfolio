package com.app.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Aoj {
    private Stat status;
    public Aoj(){}

    public Stat getStatus() {
        return status;
    }

    public void setStatus(Stat status) {
        this.status = status;
    }
}
