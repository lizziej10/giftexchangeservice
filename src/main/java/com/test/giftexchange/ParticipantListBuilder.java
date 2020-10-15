package com.test.giftexchange;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParticipantListBuilder {
    public Map<String, String> buildPairs(List<String> participants) {
        Map<String, String> pairs = new HashMap<String, String>();
        for(String participant : participants) {
            pairs.put(participant, null);
        }

        for(String giver : pairs.keySet()) {
            List<String> possibleReceivers = buildPossibleReceiver(giver,
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

    private List<String> buildPossibleReceiver(String giver, List<String> participants) {
        List<String> possibleReceivers = new ArrayList<String>();
        for(String receiver : participants) {
            if(!receiver.equals(giver)) {
                possibleReceivers.add(receiver);
            }
        }

        return possibleReceivers;
    }

}