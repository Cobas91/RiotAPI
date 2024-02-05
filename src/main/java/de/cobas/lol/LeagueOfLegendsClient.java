package de.cobas.lol;

import de.cobas.lol.responses.champion.Champion;

import java.util.HashSet;
import java.util.Set;

public class LeagueOfLegendsClient {
    LeagueOfLegendsApiDownloader leagueDownloader = new LeagueOfLegendsApiDownloader();
    public String[] getCurrentAvailableVersions(){
        return leagueDownloader.downloadVersionNumbers();
    }
    public Set<Champion> getAllChampions(){
        return new HashSet<>(leagueDownloader.getAllChampions());
    }
}
