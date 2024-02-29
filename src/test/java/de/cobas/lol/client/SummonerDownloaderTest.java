package de.cobas.lol.client;

import de.cobas.lol.responses.SummonerInformationResponse;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.PreconditionViolationException;

import static org.junit.jupiter.api.Assertions.*;

class SummonerDownloaderTest {
    @Test
    public void testSummonerInformationDownload(){
        LeagueOfLegendsClient client = new LeagueOfLegendsClientBuilder().withSummonerDownloader(System.getProperty("${RIOT_API_TOKEN}")).build();//TODO MOCKING
        SummonerInformationResponse summonerInformation = client.getSummonerDownloader().getSummonerInformation("Cobas");
        assertEquals("Cobas", summonerInformation.getName());
    }
    @Test
    public void testSummonerInformationDownloadThrowsException(){
        assertThrows(PreconditionViolationException.class, ()-> new LeagueOfLegendsClientBuilder().withSummonerDownloader("").build());
    }
}