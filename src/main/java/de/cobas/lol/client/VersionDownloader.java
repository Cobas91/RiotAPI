package de.cobas.lol.client;

import de.cobas.lol.enums.RiotApiUrl;
import de.cobas.util.HttpClientImpl;

import java.net.http.HttpRequest;

public class VersionDownloader extends HttpClientImpl {
    public VersionDownloader() {
        super(VersionDownloader.class);
    }

    public static String getCurrentPatch() {
        String[] versions = getVersionNumbers();
        return versions[0];
    }

    public static String[] getVersionNumbers() {
        HttpRequest request = getForUri(RiotApiUrl.VERSION.getUri());
        return sendRequest(request, String[].class);
    }
}
