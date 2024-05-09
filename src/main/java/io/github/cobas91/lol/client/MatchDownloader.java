package io.github.cobas91.lol.client;

import io.github.cobas91.enums.RiotRegion;
import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.lol.model.match.Match;
import io.github.cobas91.util.RiotApiHttpClient;
import lombok.Setter;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public class MatchDownloader extends RiotApiHttpClient {

    private RiotRegion region;
    public MatchDownloader(String apiToken, RiotRegion region) {
        super(MatchDownloader.class, apiToken);
        this.region = region;
    }

    /**
     * Retrieves a match object by its ID.
     *
     * @param id the ID of the match to retrieve
     * @return the Match object with the specified ID
     */
    public Match getMatchById(String id){
        HttpRequest request = getForUri(LeagueOfLegendsUrl.MATCH.getUri(Map.of("{REGION}", this.region.getUrlParameter(), "{MATCH_ID}", id)));
        return sendRequest(request, Match.class);
    }

    private List<String> getMatchIds(String puuid){
        HttpRequest request = getForUri(LeagueOfLegendsUrl.MATCHES.getUri(
                        Map.of(
                                "{REGION}", this.region.getUrlParameter(),
                                "{PUUID}", puuid
                        )
                )
        );
        return sendRequest(request, List.class);
    }



    /**
     * Retrieves all matches for a given player ID.
     * Fetches only the last 20 Matches reason is the request gatekeeper of the Official RIOTAPI
     *
     * @param puuid the player's unique ID
     * @return a List of Match objects containing the player's matches
     */
    List<Match> getAllMatches(String puuid){
        List<String> ids = getMatchIds(puuid);
        List<Match> matches = new ArrayList<>();
        for(String id : ids){
            matches.add(getMatchById(id));
        }
        return matches;
    }
}
