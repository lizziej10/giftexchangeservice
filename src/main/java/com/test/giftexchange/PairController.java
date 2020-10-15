package com.test.giftexchange;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class PairController {

    private ParticipantListBuilder participantListBuilder;
    private Map<String, String> pairs;

    PairController(ParticipantListBuilder participantListBuilder) {
        this.participantListBuilder = participantListBuilder;
    }

    @GetMapping("/pair/{id}")
    public String getPair(@PathVariable String id) {
        return "Your pair is: " + pairs.get(id);
    }

    @PostMapping("/pairs")
    public Map<String, String> createPairs(@RequestBody List<String> participants) {
        System.out.println("Executing Post.");
        pairs = participantListBuilder.buildPairs(participants);
        return pairs;
    }
}
