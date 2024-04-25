package io.github.cobas91.lol.client;

import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.util.RiotApiHttpClient;

import java.net.http.HttpRequest;

/**
 * The VersionDownloader class is responsible for downloading the current version numbers of the game.
 * It extends the HttpClientImpl class and provides methods to retrieve the current patch.
 */
public class VersionDownloader extends RiotApiHttpClient {

    VersionDownloader() {
        super(VersionDownloader.class);
    }

    /**
     * Retrieves the current patch version of the game.
     *
     * @return The current patch version as a String.
     */
    public String getCurrentPatch() {
        String[] versions = getVersionNumbers();
        return versions[0];
    }

    /**
     * Retrieves the available version numbers of the game.
     *
     * @return An array of strings representing the available versions.
     */
    public String[] getVersionNumbers() {
        HttpRequest request = getForUri(LeagueOfLegendsUrl.VERSION.getUri());
        return sendRequest(request, String[].class);
    }
}
