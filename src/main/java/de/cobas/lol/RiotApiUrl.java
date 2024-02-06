package de.cobas.lol;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public enum RiotApiUrl {
    VERSION("https://ddragon.leagueoflegends.com/api/versions.json"),
    CHAMPIONS("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion.json"),
    CHAMPION_DETAIL("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion/{CHAMPION}.json"),
    CHAMPION_SPLASH("https://ddragon.leagueoflegends.com/cdn/img/champion/splash/{CHAMPION}_{NUMBER}.jpg");
    private final String url;

    RiotApiUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }

    public URI getUri(){
        try {
            return new URI(this.url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public URI getUri(String version, Languages language){
        try {
            return new URI(this.url.replace("{VERSION}", version).replace("{LANGUAGE}", language.name()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public URI getUri(String version, Languages language, String champion){
        try {
            return new URI(this.url.replace("{VERSION}", version).replace("{LANGUAGE}", language.name()).replace("{CHAMPION}", champion));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public URL getURL(String champion, String number){
        try {
            return new URL(this.url.replace("{NUMBER}", number).replace("{CHAMPION}", champion));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
