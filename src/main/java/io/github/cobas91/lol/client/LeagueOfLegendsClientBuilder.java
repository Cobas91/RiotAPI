package io.github.cobas91.lol.client;

import io.github.cobas91.RiotSettings;
import io.github.cobas91.enums.Language;
import io.github.cobas91.enums.RiotRegion;
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
    private MatchDownloader matchDownloader;
    private final VersionDownloader versionDownloader;
    private final ItemDownloader itemDownloader;
    private final String apiToken;
    private final RiotRegion region;
    private final Language language;
    private final String version;

    LeagueOfLegendsClientBuilder(RiotSettings settings) {
        this.region = settings.getRegion();
        this.language = settings.getLanguage();
        this.versionDownloader = new VersionDownloader();
        this.version = versionDownloader.getCurrentPatch();
        this.itemDownloader = new ItemDownloader(this.version, this.language);
        this.apiToken = settings.getApiToken();
    }

    public LeagueOfLegendsClientBuilder withSummonerDownloader(){
        this.summonerDownloader = new SummonerDownloader(this.apiToken, this.region);
        return this;
    }
    /**
     * Sets the ChampionDownloader with the specified language.
     *
     * @return The LeagueOfLegendsClientBuilder object with the ChampionDownloader set.
     */
    public LeagueOfLegendsClientBuilder withChampionDownloader(){
        this.championDownloader = new ChampionDownloader(this.version, this.language);
        return this;
    }

    public LeagueOfLegendsClientBuilder withMatchDownloader(){
        this.matchDownloader = new MatchDownloader(this.apiToken, this.region);
        return this;
    }

    public LeagueOfLegendsClient build(){
        return new LeagueOfLegendsClient(this);
    }
}
