package com.supimon.recommendationsservice.resource;

import com.supimon.recommendationsservice.models.RecommendationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationService {

    @RequestMapping("/{chefId}")
    public int getRecommendations(@PathVariable("chefId") String chefId){
        return getAllRecommendations(chefId).size();
    }

    private List<RecommendationModel> getAllRecommendations(String chefId){
        return Collections.singletonList(
          new RecommendationModel("EMP23")
        );
    }
}
