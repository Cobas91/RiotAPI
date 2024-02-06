package de.cobas.lol;

import de.cobas.lol.model.Champion;
import de.cobas.lol.model.ChampionSkinInfo;
import de.cobas.lol.responses.champion.LeagueOfLegendsChampResponse;
import de.cobas.util.HttpClientImpl;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    public void setSkinSplashes(Champion champion){
        for (ChampionSkinInfo skin : champion.getSkins()) {
            skin.setImage(getIconAsByteArray(champion, skin.getNum()));
        }
    }
    public void setDefaultChampSplash(Champion champion){
        champion.setChampionIcon(getIconAsByteArray(champion, "0"));
    }
    public byte[] getIconAsByteArray(Champion champ, String iconNumber){
        return getByteArrayForImage(downloadChampionIcon(champ.getName(), iconNumber));
    }
    private byte[] getByteArrayForImage(BufferedImage image){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private BufferedImage downloadChampionIcon(String championName, String iconNumber) {
        try {
            log.info("Get Icon for "+championName+" with IconNumber "+iconNumber);
            return ImageIO.read(RiotApiUrl.CHAMPION_SPLASH.getURL(championName, iconNumber));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
