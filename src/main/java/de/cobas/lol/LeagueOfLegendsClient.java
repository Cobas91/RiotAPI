package de.cobas.lol;

import de.cobas.RiotApiAuthenticationException;
import de.cobas.lol.model.Champion;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
public class LeagueOfLegendsClient {
    private String apiToken;

    public LeagueOfLegendsClient(String apiToken) {
        this.apiToken = apiToken;
    }
    public LeagueOfLegendsClient() {
    }

    LeagueOfLegendsApiDownloader leagueDownloader = new LeagueOfLegendsApiDownloader();
    public String[] getCurrentAvailableVersions(){
        return leagueDownloader.downloadVersionNumbers();
    }
    public Set<Champion> getAllChampions(){
        return new HashSet<>(leagueDownloader.getAllChampions());
    }
    public void sendAuthenticatedRequest(){
        if(apiToken == null){
            throw new RiotApiAuthenticationException();
        }
    }
}
