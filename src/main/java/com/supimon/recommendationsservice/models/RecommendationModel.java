package com.supimon.recommendationsservice.models;

public class RecommendationModel {

    private String userId;

    public RecommendationModel(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
