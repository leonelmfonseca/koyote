package com.koyote.gather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultController {
    @GetMapping("/results")
    List<String> search(@RequestParam String search) {

        ArrayList<String> list = new ArrayList<>();
        list.add("You want to search for " + search);
        return list;
    }
}
