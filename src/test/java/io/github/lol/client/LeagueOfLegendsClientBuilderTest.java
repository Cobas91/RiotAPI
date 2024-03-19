package io.github.lol.client;

import io.github.cobas91.enums.Language;
import io.github.cobas91.lol.client.LeagueOfLegendsClient;
import org.junit.jupiter.api.Test;

class LeagueOfLegendsClientBuilderTest {

    @Test
    public void test(){
        LeagueOfLegendsClient client = LeagueOfLegendsClient.builder().withChampionDownloader(Language.en_US).build();
    }

}