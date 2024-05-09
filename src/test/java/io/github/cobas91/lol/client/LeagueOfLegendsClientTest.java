package io.github.cobas91.lol.client;

import io.github.cobas91.RiotSettings;
import io.github.cobas91.enums.Language;
import io.github.cobas91.enums.RiotRegion;
import io.github.cobas91.lol.model.item.Item;
import io.github.cobas91.lol.model.match.Match;
import io.github.cobas91.lol.model.summoner.Summoner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeagueOfLegendsClientTest {
    static String token;
    static RiotSettings settings;
    static LeagueOfLegendsClient client;

    @BeforeAll
    static void setUpBeforeClass() {
        token = System.getenv("RIOT_API_TOKEN");
        System.out.println("TOKEN:"+token);
        settings = RiotSettings.builder().apiToken(token).region(RiotRegion.EUW1).language(Language.de_DE).build();
        client = LeagueOfLegendsClient.builder(settings).withMatchDownloader().withSummonerDownloader().withChampionDownloader().build();
    }

    @Test
    void testMatchDownload() {
        Summoner summoner = client.getSummonerDownloader().getSummonerInformation("Cobas", "1505");
        assertNotNull(summoner);
        List<Match> matches = client.getMatchDownloader().getAllMatches(summoner.getPuuid());
        assertEquals(20, matches.size());
        for (Match match : matches) {
            assertEquals(10, match.getMetadata().getParticipants().size());
        }
    }
    @Test
    void testItemDownloader(){
        ItemDownloader itemDownloader = client.getItemDownloader();
        List<Item> allItems = itemDownloader.getAllItems();
        assertTrue(allItems.size() > 1);
    }

}