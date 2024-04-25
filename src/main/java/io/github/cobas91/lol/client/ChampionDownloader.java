package io.github.cobas91.lol.client;

import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.util.ImageDownloader;
import io.github.cobas91.util.RiotApiHttpClient;
import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.model.champion.Champion;
import io.github.cobas91.lol.model.champion.ChampionSkinInfo;
import io.github.cobas91.lol.responses.LeagueOfLegendsChampResponse;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a Champion Downloader that is used to download
 * and retrieve information about champions in the game League of Legends.
 * It extends the HttpClientImpl class.
 */
@Setter
public class ChampionDownloader extends RiotApiHttpClient {
    private String patchVersion;
    private Language language;

    ChampionDownloader(String patchVersion, Language language) {
        super(ChampionDownloader.class);
        this.patchVersion = patchVersion;
        this.language = language;
    }

    /**
     * Retrieves detailed information about all champions in the game League of Legends.
     *
     * @return A list of Champion objects representing all champions.
     */
    public List<Champion> getAllChampions() {
        HttpRequest allChampRequest = getForUri(LeagueOfLegendsUrl.CHAMPIONS.getUri(
                        Map.of(
                                "{VERSION}", patchVersion,
                                "{LANGUAGE}", language.name())
                )
        );
        LeagueOfLegendsChampResponse leagueOfLegendsChampResponse = sendRequest(allChampRequest, LeagueOfLegendsChampResponse.class);
        return getDetailedChampionInformation(leagueOfLegendsChampResponse);
    }

    /**
     * Retrieves detailed information about each champion in the League of Legends game.
     *
     * @param response The LeagueOfLegendsChampResponse object containing the champion data.
     * @return A list of Champion objects representing the detailed information for each champion.
     */
    private List<Champion> getDetailedChampionInformation(LeagueOfLegendsChampResponse response) {
        List<Champion> result = new ArrayList<>();
        response.getData().forEach((championName, champData) -> {
            HttpRequest request = getForUri(LeagueOfLegendsUrl.CHAMPION_DETAIL.getUri(Map.of(
                    "{VERSION}", patchVersion,
                    "{LANGUAGE}", language.name(),
                    "{CHAMPION}",championName
            )));
            LeagueOfLegendsChampResponse championResponse = sendRequest(request, LeagueOfLegendsChampResponse.class);
            result.add(championResponse.getData().get(championName));
        });
        return result;
    }

    /**
     * Sets the skin splashes for the given champion.
     * Each skin's image is obtained as a byte array using the champion's name and skin number.
     * The obtained image is then set as the skin's image.
     *
     * @param champion The champion object for which the skin splashes should be set.
     */
    public void setSkinSplashes(Champion champion) {
        for (ChampionSkinInfo skin : champion.getSkins()) {
            skin.setImage(getIconAsByteArray(champion, skin.getNum()));
        }
    }

    /**
     * Sets the default champion splash for the given champion.
     *
     * @param champion The champion for which the default champion splash should be set.
     */
    public void setDefaultChampSplash(Champion champion) {
        champion.setChampionIcon(getIconAsByteArray(champion, "0"));
    }

    /**
     * Retrieves the icon of a champion as a byte array.
     *
     * @param champ      The Champion object representing the champion.
     * @param iconNumber The number of the icon to retrieve.
     * @return The champion's icon as a byte array.
     */
    public byte[] getIconAsByteArray(Champion champ, String iconNumber) {
        return ImageDownloader.downloadImage(LeagueOfLegendsUrl.CHAMPION_SPLASH.getURL(
                Map.of(
                        "{CHAMPION}",champ.getName(),
                        "{NUMBER}",iconNumber
                )));
    }
}
