package de.cobas.lol;

import java.net.URI;
import java.net.URISyntaxException;

public enum RiotApiUrl {
    VERSION("https://ddragon.leagueoflegends.com/api/versions.json"),
    CHAMPIONS("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion.json"),
    CHAMPION_DETAIL("https://ddragon.leagueoflegends.com/cdn/{VERSION}/data/{LANGUAGE}/champion/{CHAMPION}");
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
            return new URI(this.url.replace("{VERSION}", version).replace("{LANGUAGE}", language.name()).replace("{CHAMPION}", champion)+".json");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
