package com.test.giftexchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ParticipantListBuilderTest {
    @Test
    public void buildPairsListEvenNumberOfParticipants() {

        ParticipantListBuilder tester = new ParticipantListBuilder(); // MyClass is tested

        Map<String, String> participants = new HashMap<String, String>();
        participants.put("name_1", "family_1");
        participants.put("name_2", "family_2");
        participants.put("name_3", "family_1");
        participants.put("name_4", "family_2");

        Map<String, String> results = tester.buildPairs(participants);

        // assert statements
        assertEquals(4, results.size());
        for(Map.Entry<String, String> result : results.entrySet()) {
            assertTrue(result.getKey() != result.getValue());
        }
    }

    @Test()
    public void buildPairsListNoReceiversError() {

        ParticipantListBuilder tester = new ParticipantListBuilder(); // MyClass is tested

        Map<String, String> participants = new HashMap<String, String>();
        participants.put("name_1", "family_1");
        participants.put("name_2", "family_2");
        participants.put("name_3", "family_1");

        try {
            Map<String, String> results = tester.buildPairs(participants);
        } catch(RuntimeException e) {
            assertTrue(e.getMessage().contains("ERROR: No receivers available for giver "));
        }
        // assert statements
    }

    @Test
    public void buildPairsListNoParticipants() {

        ParticipantListBuilder tester = new ParticipantListBuilder(); // MyClass is tested

        Map<String, String> participants = new HashMap<String, String>();

        Map<String, String> results = tester.buildPairs(participants);

        // assert statements
        assertEquals(0, results.size());
    }
}
