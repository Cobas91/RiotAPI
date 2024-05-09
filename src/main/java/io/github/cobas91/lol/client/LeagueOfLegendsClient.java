package io.github.cobas91.lol.client;

import io.github.cobas91.RiotSettings;
import io.github.cobas91.lol.model.match.Match;
import io.github.cobas91.lol.model.summoner.Summoner;
import lombok.Getter;

import java.util.List;

/**
 * The LeagueOfLegendsClient class represents a client for interacting with the League of Legends API.
 * It provides methods to retrieve the current available versions of the game and to download champion and summoner data.
 */
@Getter
public class LeagueOfLegendsClient {

    private final ChampionDownloader championDownloader;
    private final SummonerDownloader summonerDownloader;
    private final MatchDownloader matchDownloader;
    private final ItemDownloader itemDownloader;

    protected LeagueOfLegendsClient(LeagueOfLegendsClientBuilder builder) {
        this.championDownloader = builder.getChampionDownloader();
        this.summonerDownloader = builder.getSummonerDownloader();
        this.matchDownloader = builder.getMatchDownloader();
        this.itemDownloader = builder.getItemDownloader();
    }

    /**
     * Retrieves all matches for a given Riot ID.
     * RiotId Example: Cobas#1505 -> Cobas = name, 1505 -> tag
     * @param name the name of the summoner
     * @param tag the tag of the summoner
     * @return a List of Match objects containing the summoner's last 20 matches
     */
    public List<Match> getAllMatchesByRiotId(String name, String tag){
        Summoner summonerInformation = this.summonerDownloader.getSummonerInformation(name, tag);
        return this.matchDownloader.getAllMatches(summonerInformation.getPuuid());
    }

    public static LeagueOfLegendsClientBuilder builder(RiotSettings settings){
        return new LeagueOfLegendsClientBuilder(settings);
    }
}
