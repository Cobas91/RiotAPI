package de.cobas.lol.client;

import de.cobas.lol.enums.Language;
import lombok.Getter;
import lombok.NonNull;
import org.junit.platform.commons.util.Preconditions;

@Getter
public class LeagueOfLegendsClientBuilder {
    private ChampionDownloader championDownloader;
    private SummonerDownloader summonerDownloader;
    private String apiToken;

    public LeagueOfLegendsClientBuilder withSummonerDownloader(@NonNull String apiToken){
        Preconditions.notBlank(apiToken, "You have to set a valid ApiToken to use the Summoner Downloader");
        this.apiToken = apiToken;
        this.summonerDownloader = new SummonerDownloader(apiToken);
        return this;
    }
    public LeagueOfLegendsClientBuilder withChampionDownloader(Language language){
        this.championDownloader = new ChampionDownloader(VersionDownloader.getCurrentPatch(), language);
        return this;
    }
    public LeagueOfLegendsClient build(){
        return new LeagueOfLegendsClient(this);
    }
}
