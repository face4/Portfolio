package com.app.portfolio;

public class YukicoderEntity {
     Long Id;
     String Name;
     Long Solved;
     Long Level;
     Double LevelFloat;
     Long Rank;
     Long Score;
     Long Points;
     String Notice;
     String AtCoderId;
     String CodeforcesId;
    public YukicoderEntity(){}

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

    public Long getLevel() {
        return Level;
    }

    public void setLevel(Long level) {
        Level = level;
    }

    public Double getLevelFloat() {
        return LevelFloat;
    }

    public void setLevelFloat(Double levelFloat) {
        LevelFloat = levelFloat;
    }

    public Long getRank() {
        return Rank;
    }

    public void setRank(Long rank) {
        Rank = rank;
    }

    public Long getScore() {
        return Score;
    }

    public void setScore(Long score) {
        Score = score;
    }

    public Long getPoints() {
        return Points;
    }

    public void setPoints(Long points) {
        Points = points;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }

    public String getAtCoderId() {
        return AtCoderId;
    }

    public void setAtCoderId(String atCoderId) {
        AtCoderId = atCoderId;
    }

    public String getCodeforcesId() {
        return CodeforcesId;
    }

    public void setCodeforcesId(String codeforcesId) {
        CodeforcesId = codeforcesId;
    }

    @Override
    public String toString(){
        return AtCoderId;
    }
}
