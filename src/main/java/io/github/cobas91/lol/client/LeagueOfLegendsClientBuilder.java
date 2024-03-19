package io.github.cobas91.lol.client;

import io.github.cobas91.enums.Language;
import lombok.Getter;
import lombok.NonNull;

/**
 * The LeagueOfLegendsClientBuilder class is responsible for building instances of LeagueOfLegendsClient.
 * It provides methods to configure the ChampionDownloader and SummonerDownloader objects used by the client.
 * The API token is also set using the withSummonerDownloader method.
 */
@Getter
public class LeagueOfLegendsClientBuilder {
    private ChampionDownloader championDownloader;
    private SummonerDownloader summonerDownloader;
    private String apiToken;

    public LeagueOfLegendsClientBuilder withSummonerDownloader(@NonNull String apiToken){
        this.apiToken = apiToken;
        this.summonerDownloader = new SummonerDownloader(apiToken);
        return this;
    }
    /**
     * Sets the ChampionDownloader with the specified language.
     *
     * @param language The language for which the ChampionDownloader should be set.
     * @return The LeagueOfLegendsClientBuilder object with the ChampionDownloader set.
     */
    public LeagueOfLegendsClientBuilder withChampionDownloader(Language language){
        this.championDownloader = new ChampionDownloader(VersionDownloader.getCurrentPatch(), language);
        return this;
    }
    public LeagueOfLegendsClient build(){
        return new LeagueOfLegendsClient(this);
    }
}
