package io.github.cobas91.lol.client;

import io.github.cobas91.enums.RiotRegion;
import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.lol.model.match.Match;
import io.github.cobas91.util.RiotApiHttpClient;
import lombok.Setter;

import java.net.http.HttpRequest;
import java.util.Map;

public class MatchDownloader extends RiotApiHttpClient {
    @Setter
    private RiotRegion region;
    public MatchDownloader(String apiToken, RiotRegion region) {
        super(MatchDownloader.class, apiToken);
        this.region = region;
    }

    public Match getMatchById(String id){
        HttpRequest request = getForUri(LeagueOfLegendsUrl.MATCH.getUri(Map.of("{REGION}", this.region.getUrlParameter(), "{MATCH_ID}", id)));
        return sendRequest(request, Match.class);
    }
}
