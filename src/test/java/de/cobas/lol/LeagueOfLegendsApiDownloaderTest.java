package de.cobas.lol;

import de.cobas.lol.model.Champion;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueOfLegendsApiDownloaderTest {
    LeagueOfLegendsApiDownloader downloader = new LeagueOfLegendsApiDownloader();
    Logger log = Logger.getLogger(LeagueOfLegendsApiDownloaderTest.class);

    @Test
    @DisplayName("Test if the Download of the current Versions numbers return min. 1 Number.")
    public void testVersionDownload(){
        String[] versions = downloader.downloadVersionNumbers();
        assertTrue(versions.length > 0);
    }
    @Test
    @DisplayName("Test if the Download of all Champions is not a Empty result")
    public void testDownloadAllChampions(){
        List<Champion> allChampions = downloader.getAllChampions();
         assertFalse(allChampions.isEmpty());
    }

    @Test
    @DisplayName("Test if the Download of the icons for one champ is successfully")
    public void testDownloadAllSplashIcons(){
        List<Champion> allChampions = downloader.getAllChampions();
        Champion testChamp = allChampions.get(0);
        downloader.setDefaultChampSplash(testChamp);
        downloader.setSkinSplashes(testChamp);
        assertNotNull(testChamp.getChampionIcon());
        assertNotNull(testChamp.getSkins().get(3).getImage());
    }

}