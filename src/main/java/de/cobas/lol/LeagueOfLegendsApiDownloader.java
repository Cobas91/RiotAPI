package de.cobas.lol;

import de.cobas.lol.responses.champion.Champion;
import de.cobas.lol.responses.champion.LeagueOfLegendsChampResponse;
import de.cobas.util.HttpClientImpl;
import lombok.Setter;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Setter
public class LeagueOfLegendsApiDownloader extends HttpClientImpl {

    private String patchVersion;
    private Languages language = Languages.en_US;
    public LeagueOfLegendsApiDownloader() {
        super(LeagueOfLegendsApiDownloader.class);
        initPatchVersion();
    }

    private void initPatchVersion() {
        String[] versions = downloadVersionNumbers();
        this.patchVersion = versions[0];
    }

    public String[] downloadVersionNumbers() {
        HttpRequest request = getForUri(RiotApiUrl.VERSION.getUri());
        return sendRequest(request, String[].class);
    }

    public List<Champion> getAllChampions() {
        HttpRequest allChampRequest = getForUri(RiotApiUrl.CHAMPIONS.getUri(patchVersion, language));
        LeagueOfLegendsChampResponse leagueOfLegendsChampResponse = sendRequest(allChampRequest, LeagueOfLegendsChampResponse.class);
        return getDetailedChampionInformation(leagueOfLegendsChampResponse);
    }
    private List<Champion> getDetailedChampionInformation(LeagueOfLegendsChampResponse response){
        List<Champion> result = new ArrayList<>();
        response.getData().forEach((championName, champData)->{
            HttpRequest request = getForUri(RiotApiUrl.CHAMPION_DETAIL.getUri(patchVersion, language, championName));
            LeagueOfLegendsChampResponse championResponse = sendRequest(request, LeagueOfLegendsChampResponse.class);
            result.add(championResponse.getData().get(championName));
        });
        return result;
    }
}
