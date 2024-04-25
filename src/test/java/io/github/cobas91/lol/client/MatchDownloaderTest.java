package io.github.cobas91.lol.client;

import io.github.cobas91.enums.RiotRegion;
import io.github.cobas91.lol.model.match.Match;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchDownloaderTest {

    @Test
    void testMatchDownload(){
        String matchId = "EUW1_6899046329";
        MatchDownloader matchDownloader = new MatchDownloader("RGAPI-4ff0b363-c47d-41a5-a2f8-715ab2c25d14", RiotRegion.EUW1);
        Match matchById = matchDownloader.getMatchById(matchId);
        assertEquals(matchById.getMetadata().getMatchId(), matchId);
    }
}