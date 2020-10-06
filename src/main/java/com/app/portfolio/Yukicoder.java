package com.app.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class Yukicoder {
     Long Id;
     String Name;
     Long Solved;
     public Yukicoder(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getSolved() {
        return Solved;
    }

    public void setSolved(Long solved) {
        Solved = solved;
    }

    @Override
     public String toString(){
        return Name + " : " + Solved;
    }
}
