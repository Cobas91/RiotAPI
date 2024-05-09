package io.github.cobas91.lol;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/**
 * Enumeration class representing the League of Legends API URLs.
 */
public enum LeagueOfLegendsUrl {
    VERSION("https://ddragon.leagueoflegends.com/api/versions.json"),
    CHAMPIONS("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion.json"),
    CHAMPION_DETAIL("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion/{CHAMPION}.json"),
    CHAMPION_SPLASH("https://ddragon.leagueoflegends.com/cdn/img/champion/splash/{CHAMPION}_{NUMBER}.jpg"),
    SUMMONER_BY_RIOT_ID("https://{REGION}.api.riotgames.com/riot/account/v1/accounts/by-riot-id/{NAME}/{TAG}"),
    SUMMONER("https://{REGION}.api.riotgames.com/lol/summoner/v4/summoners/by-name/{NAME}"),
    MATCH("https://{REGION}.api.riotgames.com/lol/match/v5/matches/{MATCH_ID}"),
    MATCHES("https://{REGION}.api.riotgames.com/lol/match/v5/matches/by-puuid/{PUUID}/ids?start=0&count=20"),
    ITEM("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/item.json"),
    ITEM_SPASH("https://ddragon.leagueoflegends.com/cdn/{VERSION}/img/item/{ITEM_ID}.png");
    private final String url;

    LeagueOfLegendsUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }

    public URI getUri() {
        try {
            return new URI(this.url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public URL getURL(Map<String, String> replacements) {
        try {
            return new URL(replaceUrl(replacements));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI getUri(Map<String, String> replacements) {
        return URI.create(replaceUrl(replacements));
    }

    private String replaceUrl(Map<String, String> replacements){
        String url = this.url;
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            url = url.replace(entry.getKey(), entry.getValue());
        }
        return url;
    }
}
