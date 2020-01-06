package com.supimon.recommendationsservice.models;

public class RecommendationModel {

    private String userId;
    private Long recommendations;

    public RecommendationModel() {
    }

    public RecommendationModel(String userId, Long recommendations) {
        this.userId = userId;
        this.recommendations = recommendations;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Long recommendations) {
        this.recommendations = recommendations;
    }
}
