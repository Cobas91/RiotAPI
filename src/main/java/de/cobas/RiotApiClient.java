package de.cobas;


import de.cobas.lol.StaticApiDownloader;

public class RiotApiClient {

    public String[] getCurrentVersions(){
        return StaticApiDownloader.downloadVersionNumbers();
    }
}
