package com.test.giftexchange;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        when(participantListBuilderMock.buildPairs(anyMap())).thenReturn(new HashMap<String, String>());

        tester.createPairs(new HashMap<String, String>());

        verify(participantListBuilderMock).buildPairs(anyMap());
    }

    @Test
    public void testPostBuildPairsError() {
        when(participantListBuilderMock.buildPairs(anyMap())).thenThrow(new RuntimeException("No pairs exception."));

        try {
            tester.createPairs(new HashMap<String, String>());
        } catch(RuntimeException e) {
            assertTrue(e.getMessage().equals("No pairs exception."));
        }

        verify(participantListBuilderMock).buildPairs(anyMap());
    }
}

