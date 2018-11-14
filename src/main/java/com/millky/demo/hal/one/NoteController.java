package com.millky.demo.hal.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public List<Note> testPagedResources() {

        ResponseEntity<PagedResources<Note>> responseEntity = restTemplate.exchange("http://localhost:8080/notes/search/findByOrderByIdDesc",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<PagedResources<Note>>() {
                });

        PagedResources<Note> resources = responseEntity.getBody();

        List<Note> notes = new ArrayList(resources.getContent());

        return notes;
    }
}
