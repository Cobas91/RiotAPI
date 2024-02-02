package de.cobas.lol;

import de.cobas.RiotApiClient;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticApiDownloaderTest {
    Logger log = Logger.getLogger(StaticApiDownloaderTest.class);

    @Test
    @DisplayName("Test if the Download of the current Versions numbers return min. 1 Number.")
    public void testVersionDownload(){
        String[] versions = StaticApiDownloader.downloadVersionNumbers();
        assertTrue(versions.length > 0);
    }

}