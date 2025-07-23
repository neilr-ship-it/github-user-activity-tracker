package com.githubtracker.activity.controller;

import com.githubtracker.activity.service.GithubService;
import org.springframework.web.bind.annotation.*;
import com.githubtracker.activity.model.GithubEvent;
import java.util.List;

@RestController
public class ActivityController {
    private final GithubService githubService;

    public ActivityController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/github")
    public List<GithubEvent> getUserActivity(@RequestParam( name = "user") String user, @RequestParam(name = "type", required = false) String type) {
        return githubService.fetchUserEvents(user, type);
        //need to implement fetchUserEvents in GithubService
        
    }


    



}
