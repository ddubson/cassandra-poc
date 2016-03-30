package com.ddubson.filmfox.services.sync.impl;

import com.ddubson.filmfox.ElasticsearchClient;
import com.ddubson.filmfox.aop.TrackExecutionTime;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.services.movie.MovieService;
import com.ddubson.filmfox.services.sync.IndexingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class IndexingServiceImpl implements IndexingService {
    @Autowired
    Logger sysLog;

    @Autowired
    MovieService movieService;

    @Autowired
    ElasticsearchClient elasticsearchClient;

    @Autowired
    ObjectMapper json;

    @Override
    @Scheduled(fixedRate = 50000, initialDelay = 10000)
    @TrackExecutionTime
    public void sync() {
        sysLog.info("Scheduled indexing service started at " + DateTime.now().toString());

        int exceptionCount = 0;
        for (Movie movie : movieService.getMovieSummaries()) {
            sysLog.info("Indexing " + movie.getName() + "...");

            IndexResponse response = null;
            try {
                // TODO bulk insert set of movies instead of individual insertions
                // index movie by ID
                response = elasticsearchClient.getElasticClient().prepareIndex(
                        ElasticsearchClient.MOVIES_INDEX,
                        ElasticsearchClient.MOVIES_TYPE,
                        movie.getId().toString())
                        .setSource(json.writeValueAsBytes(movie)).get();
            } catch (JsonProcessingException e) {
                sysLog.error("Indexing exception for " + movie.getName() + ". Please observe error.", e);
                sysLog.info("Skipping to next entity...");
                exceptionCount++;
            }

            if (response != null && response.isCreated()) {
                sysLog.info("Done indexing " + movie.getName() + ".");
            }
        }

        sysLog.info("Scheduled indexing service finished at " + DateTime.now().toString() + ". There were " + exceptionCount + " issues.");
    }
}
