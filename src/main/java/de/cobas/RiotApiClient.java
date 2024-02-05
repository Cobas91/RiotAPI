package de.cobas;


import de.cobas.lol.LeagueOfLegendsClient;

public class RiotApiClient {
    public LeagueOfLegendsClient getLeagueOfLegendsClient(){
        return new LeagueOfLegendsClient();
    }
}
