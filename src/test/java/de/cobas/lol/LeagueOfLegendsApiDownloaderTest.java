package de.cobas.lol;

import de.cobas.lol.responses.champion.Champion;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}