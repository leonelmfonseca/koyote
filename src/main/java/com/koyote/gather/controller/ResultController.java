package com.koyote.gather.controller;

import com.koyote.gather.service.GmailQuickstart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class ResultController {

    private GmailQuickstart gmailQuickstart;
    @Autowired
    public ResultController(GmailQuickstart gmailQuickstart) {
        this.gmailQuickstart = gmailQuickstart;
    }

    @GetMapping("/results")
    List<String> search(@RequestParam String search) throws GeneralSecurityException, IOException {


        return gmailQuickstart.getMessages();

    }



}
