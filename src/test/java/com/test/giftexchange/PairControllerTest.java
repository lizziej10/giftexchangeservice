package com.test.giftexchange;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class PairControllerTest {

    ParticipantListBuilder participantListBuilderMock;

    PairController tester;

    @BeforeEach
    public void before() {
        participantListBuilderMock = mock(ParticipantListBuilder.class);
        tester = new PairController(participantListBuilderMock);
    }

    @Test
    public void testPostBuildPairs() {
        when(participantListBuilderMock.buildPairs(anyList())).thenReturn(new HashMap<String, String>());

        tester.createPairs(new ArrayList<String>());

        verify(participantListBuilderMock).buildPairs(anyList());
    }

    @Test
    public void testPostBuildPairsError() {
        when(participantListBuilderMock.buildPairs(anyList())).thenThrow(new RuntimeException("No pairs exception."));

        try {
            tester.createPairs(new ArrayList<String>());
        } catch(RuntimeException e) {
            assertTrue(e.getMessage().equals("No pairs exception."));
        }

        verify(participantListBuilderMock).buildPairs(anyList());
    }
}

