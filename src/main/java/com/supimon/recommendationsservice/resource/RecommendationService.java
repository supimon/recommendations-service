package com.supimon.recommendationsservice.resource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.supimon.recommendationsservice.models.RecommendationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationService {

    @RequestMapping("/{chefId}")
    public int getRecommendations(@PathVariable("chefId") String chefId) throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/chefapp-eeae0-firebase-adminsdk-tujtr-198a71e00a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://chefapp-eeae0.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        return getAllRecommendations(chefId).size();
    }

    private List<RecommendationModel> getAllRecommendations(String chefId){
        return Collections.singletonList(
          new RecommendationModel("EMP23")
        );
    }
}
