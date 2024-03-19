package io.github.cobas91.lol.client;

import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.lol.responses.SummonerInformationResponse;
import io.github.cobas91.util.HttpClientImpl;
import io.github.cobas91.enums.RiotRegion;

import java.net.http.HttpRequest;

public class SummonerDownloader extends HttpClientImpl {
    public SummonerDownloader(String apiToken) {
        super(SummonerDownloader.class, apiToken);
    }

    /**
     * Retrieves the information of a summoner given their name.
     *
     * @param summonerName the name of the summoner
     * @return a SummonerInformationResponse object containing the summoner information
     */
    public SummonerInformationResponse getSummonerInformation(String summonerName){
        HttpRequest request = getForUri(LeagueOfLegendsUrl.SUMMONER.getUri(summonerName, RiotRegion.EUW1));
        return sendRequest(request, SummonerInformationResponse.class);
    }
}
