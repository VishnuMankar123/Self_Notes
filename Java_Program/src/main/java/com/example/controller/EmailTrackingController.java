package com.example.controller;


import com.example.service.EmailTrackingService;
import com.example.service.VishnuEmailTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
public class EmailTrackingController {

    private final EmailTrackingService emailTrackingService;
    private final VishnuEmailTrackingService vishnuEmailTrackingService;


    @PostMapping
    public List<String> saveEmail(@RequestBody List<String> recipients) {
        return emailTrackingService.saveEmail(recipients);
    }

    @PostMapping("/vishnu")
    public List<String> vishnuSaveEmail(@RequestBody List<String> recipients) {
        return vishnuEmailTrackingService.vishnuSaveEmail(recipients);
    }
}