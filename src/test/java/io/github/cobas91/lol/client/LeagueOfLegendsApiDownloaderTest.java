package io.github.cobas91.lol.client;

import io.github.cobas91.RiotSettings;
import io.github.cobas91.enums.RiotRegion;
import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.model.champion.Champion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueOfLegendsApiDownloaderTest {
    RiotSettings settings = RiotSettings.builder().region(RiotRegion.EUW1).language(Language.de_DE).build();
    @Test
    @DisplayName("Test if the Download of the current Versions numbers return min. 1 Number.")
    public void testVersionDownload(){
        VersionDownloader versionDownloader = new VersionDownloader();
        String[] versions = versionDownloader.getVersionNumbers();
        assertTrue(versions.length > 0);
    }
    @Test
    @DisplayName("Test if the Download of all Champions is not a Empty result")
    public void testDownloadAllChampions(){
        LeagueOfLegendsClient client = LeagueOfLegendsClient.builder(settings).withChampionDownloader().build();
        List<Champion> allChampions = client.getChampionDownloader().getAllChampions();
         assertFalse(allChampions.isEmpty());
    }

    @Test
    @DisplayName("Test if the Download of the icons for one champ is successfully")
    public void testDownloadAllSplashIcons(){
        LeagueOfLegendsClient client = LeagueOfLegendsClient.builder(settings).withChampionDownloader().build();
        List<Champion> allChampions = client.getChampionDownloader().getAllChampions();
        Champion testChamp = allChampions.get(0);
        client.getChampionDownloader().setDefaultChampSplash(testChamp);
        client.getChampionDownloader().setSkinSplashes(testChamp);
        assertNotNull(testChamp.getChampionIcon());
        assertNotNull(testChamp.getSkins().get(3).getImage());
    }

}