package io.github.lol;

import io.github.cobas91.lol.client.LeagueOfLegendsClient;
import io.github.cobas91.lol.client.LeagueOfLegendsClientBuilder;
import io.github.cobas91.lol.client.VersionDownloader;
import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.model.Champion;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueOfLegendsApiDownloaderTest {
    Logger log = Logger.getLogger(LeagueOfLegendsApiDownloaderTest.class);

    @Test
    @DisplayName("Test if the Download of the current Versions numbers return min. 1 Number.")
    public void testVersionDownload(){
        String[] versions = VersionDownloader.getVersionNumbers();
        assertTrue(versions.length > 0);
    }
    @Test
    @DisplayName("Test if the Download of all Champions is not a Empty result")
    public void testDownloadAllChampions(){
        LeagueOfLegendsClient client = LeagueOfLegendsClient.builder().withChampionDownloader(Language.en_US).build();
        List<Champion> allChampions = client.getChampionDownloader().getAllChampions();
         assertFalse(allChampions.isEmpty());
    }

    @Test
    @DisplayName("Test if the Download of the icons for one champ is successfully")
    public void testDownloadAllSplashIcons(){
        LeagueOfLegendsClient client = new LeagueOfLegendsClientBuilder().withChampionDownloader(Language.en_US).build();
        List<Champion> allChampions = client.getChampionDownloader().getAllChampions();
        Champion testChamp = allChampions.get(0);
        client.getChampionDownloader().setDefaultChampSplash(testChamp);
        client.getChampionDownloader().setSkinSplashes(testChamp);
        assertNotNull(testChamp.getChampionIcon());
        assertNotNull(testChamp.getSkins().get(3).getImage());
    }

}