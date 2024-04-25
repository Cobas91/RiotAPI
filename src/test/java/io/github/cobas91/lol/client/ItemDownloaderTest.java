package io.github.cobas91.lol.client;

import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.model.item.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDownloaderTest {

    private ItemDownloader itemDownloader = new ItemDownloader("14.8.1", Language.de_DE);

    @Test
    void testItemDownload(){
        List<Item> allItems = itemDownloader.getAllItems();
        byte[] bytes = itemDownloader.downloadItemSplash(allItems.get(9).getId());
        assertFalse(allItems.isEmpty());
    }

}