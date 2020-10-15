package com.test.giftexchange;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParticipantListBuilder {
    public Map<String, String> buildPairs(Map<String, String> participants) {
        Map<String, String> pairs = new HashMap<String, String>();

        for(String participant : participants.keySet()) {
            pairs.put(participant, null);
        }

        for(String giver : pairs.keySet()) {
            List<String> possibleReceivers = buildPossibleReceiver(giver,
                    participants.get(giver),
                    participants);
            if(possibleReceivers.isEmpty()) {
                throw new RuntimeException("ERROR: No receivers available for giver " + giver);
            }

            int randIndex = (int)(Math.random() * possibleReceivers.size());
            String receiver = possibleReceivers.get(randIndex);

            pairs.put(giver, receiver);

            participants.remove(receiver);
        }

        return pairs;
    }

    private List<String> buildPossibleReceiver(String giver, String giverFamily, Map<String, String> participants) {
        List<String> possibleReceivers = new ArrayList<String>();
        for(Map.Entry<String, String> receiver : participants.entrySet()) {
            if(!receiver.getKey().equals(giver) && !receiver.getValue().equals(giverFamily)) {
                possibleReceivers.add(receiver.getKey());
            }
        }

        return possibleReceivers;
    }

}