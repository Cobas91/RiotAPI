package io.github.cobas91.lol.client;

import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.LeagueOfLegendsUrl;
import io.github.cobas91.lol.model.item.Item;
import io.github.cobas91.lol.model.item.ItemResponse;
import io.github.cobas91.util.ImageDownloader;
import io.github.cobas91.util.RiotApiHttpClient;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDownloader extends RiotApiHttpClient {
    private final String version;
    private final Language language;

    ItemDownloader(String version, Language language) {
        super(ItemDownloader.class);
        this.version = version;
        this.language = language;
    }

    public List<Item> getAllItems() {
        HttpRequest request = getForUri(LeagueOfLegendsUrl.ITEM.getUri(Map.of(
                "{VERSION}", this.version,
                "{LANGUAGE}", this.language.name()
        )));
        ItemResponse itemResponse = sendRequest(request, ItemResponse.class);
        return getItemsFromResponse(itemResponse.getData());
    }

    private List<Item> getItemsFromResponse(Map<Integer, Item> data) {
        List<Item> result = new ArrayList<>();
        for (Map.Entry<Integer, Item> entry : data.entrySet()) {
            entry.getValue().setId(entry.getKey());
            result.add(entry.getValue());
        }
        return result;
    }

    public byte[] downloadItemSplash(Integer itemId) {
        return ImageDownloader.downloadImage(LeagueOfLegendsUrl.ITEM_SPASH.getURL(
                Map.of(
                        "{ITEM_ID}", String.valueOf(itemId),
                        "{VERSION}", this.version
                ))
        );
    }
}
