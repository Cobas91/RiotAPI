package io.github.cobas91.lol.client;

import lombok.Getter;

/**
 * The LeagueOfLegendsClient class represents a client for interacting with the League of Legends API.
 * It provides methods to retrieve the current available versions of the game and to download champion and summoner data.
 */
@Getter
public class LeagueOfLegendsClient {

    private final ChampionDownloader championDownloader;
    private final SummonerDownloader summonerDownloader;

    protected LeagueOfLegendsClient(LeagueOfLegendsClientBuilder builder) {
        this.championDownloader = builder.getChampionDownloader();
        this.summonerDownloader = builder.getSummonerDownloader();
    }

    /**
     * Retrieves the current available versions of the game.
     *
     * @return an array of strings representing the available versions
     */
    public String[] getCurrentAvailableVersions(){
        return VersionDownloader.getVersionNumbers();
    }

    public static LeagueOfLegendsClientBuilder builder(){
        return new LeagueOfLegendsClientBuilder();
    }
}
