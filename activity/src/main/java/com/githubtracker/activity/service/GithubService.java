package com.githubtracker.activity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.githubtracker.activity.model.GithubEvent;

import java.util.*;

@Service
public class GithubService {
    @Value("${github.token}")
    private String githubToken;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<GithubEvent> fetchUserEvents(String username) {
        String url = "https://api.github.com/users/" + username + "/events";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.v3+json");
        headers.set("Authorization", "Bearer " + githubToken);

        //create request entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //send the GET request
        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                List.class
        );
        //create structured way to convert raw list of events to GithubEvent objects
        List<Map<String, Object>> rawEvents = response.getBody();
        List<GithubEvent> events = new ArrayList<>();

        if(rawEvents != null) {
            for(Map<String, Object> rawEvent : rawEvents) {
                String eventType = (String) rawEvent.get("type");
                //we know that repo is a nested object where its keys and value both strings
                Map<String, Object> repoMap = (Map<String, Object>) rawEvent.get("repo");
                String repo = (String) repoMap.get("name");
                String timeStamp = (String) rawEvent.get("created_at");
                String details = "";
                if("PushEvent".equals(eventType)) {
                    Map<String, Object> payload = (Map<String, Object>) rawEvent.get("payload");
                    List<Map<String, Object>> commits = (List<Map<String, Object>>) payload.get("commits");
                    if(commits != null && !commits.isEmpty()) {
                        details =  (String) commits.get(0).get("message");
                    }
                }
                events.add(new GithubEvent(eventType, repo, timeStamp, details));
            }
        }
        return events;
    }

}
