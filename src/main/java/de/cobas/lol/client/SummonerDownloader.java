package de.cobas.lol.client;

import de.cobas.lol.enums.RiotApiUrl;
import de.cobas.lol.enums.RiotRegion;
import de.cobas.lol.responses.SummonerInformationResponse;
import de.cobas.util.HttpClientImpl;

import java.net.http.HttpRequest;

public class SummonerDownloader extends HttpClientImpl {
    public SummonerDownloader(String apiToken) {
        super(SummonerDownloader.class, apiToken);
    }

    public SummonerInformationResponse getSummonerInformation(String summonerName){
        HttpRequest request = getForUri(RiotApiUrl.SUMMONER.getUri(summonerName, RiotRegion.EUW1));
        return sendRequest(request, SummonerInformationResponse.class);
    }
}
