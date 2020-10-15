package com.test.giftexchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParticipantListBuilderTest {
    @Test
    public void buildPairsListEvenNumberOfParticipants() {

        ParticipantListBuilder tester = new ParticipantListBuilder(); // MyClass is tested

        List<String> participants = new ArrayList<String>();
        participants.add("name_1");
        participants.add("name_2");
        participants.add("name_3");
        participants.add("name_4");

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

        List<String> participants = new ArrayList<String>();
        participants.add("name_1");
        participants.add("name_2");
        participants.add("name_1");

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

        List<String> participants = new ArrayStack<String>();

        Map<String, String> results = tester.buildPairs(participants);

        // assert statements
        assertEquals(0, results.size());
    }
}
