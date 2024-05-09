package io.github.cobas91.lol.client;

import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.lol.model.summoner.Summoner;
import io.github.cobas91.util.RiotApiHttpClient;
import io.github.cobas91.enums.RiotRegion;
import lombok.Setter;

import java.net.http.HttpRequest;
import java.util.Map;
@Setter
public class SummonerDownloader extends RiotApiHttpClient {
    private RiotRegion region;

    SummonerDownloader(String apiToken, RiotRegion region) {
        super(SummonerDownloader.class, apiToken);
        this.region = region;
    }

    /**
     * Retrieves the information of a summoner given their name.
     *
     * @param summonerName the name of the summoner
     * @return a SummonerInformationResponse object containing the summoner information
     */
    public Summoner getSummonerInformation(String summonerName, String tag) {
        HttpRequest request = getForUri(LeagueOfLegendsUrl.SUMMONER_BY_RIOT_ID.getUri(
                        Map.of(
                                "{NAME}", summonerName,
                                "{TAG}", tag,
                                "{REGION}", this.region.getUrlParameter())
                )
        );
        return sendRequest(request, Summoner.class);
    }
}
