package de.cobas.lol.client;

import de.cobas.lol.model.Champion;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class LeagueOfLegendsClient {

    private final ChampionDownloader championDownloader;
    private final SummonerDownloader summonerDownloader;

    protected LeagueOfLegendsClient(LeagueOfLegendsClientBuilder builder) {
        this.championDownloader = builder.getChampionDownloader();
        this.summonerDownloader = builder.getSummonerDownloader();
    }

    public String[] getCurrentAvailableVersions(){
        return VersionDownloader.getVersionNumbers();
    }
    public Set<Champion> getAllChampions(){
        return new HashSet<>(championDownloader.getAllChampions());
    }
}
