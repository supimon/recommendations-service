package com.supimon.recommendationsservice.resource;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.supimon.recommendationsservice.models.RecommendationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/recommendations")
public class RecommendationService {

    @RequestMapping("/{chefId}")
    public Long getRecommendations(@PathVariable("chefId") String chefId) throws InterruptedException, ExecutionException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference chefRecomm = db.collection("recommendations");
        // Create a query against the collection.
        Query query = chefRecomm.whereEqualTo("chefId", chefId);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        RecommendationModel recommendationModel = new RecommendationModel();

        for (QueryDocumentSnapshot document : documents) {
            recommendationModel.setUserId(document.getString("chefId"));
            recommendationModel.setRecommendations(document.getLong("recommendations"));
        }

        return recommendationModel.getRecommendations();
    }
}
