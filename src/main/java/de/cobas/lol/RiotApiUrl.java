package de.cobas.lol;

public enum RiotApiUrl {
    VERSION("https://ddragon.leagueoflegends.com/api/versions.json");
    private final String url;

    RiotApiUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }
}
