package de.cobas.lol.client;

import de.cobas.lol.enums.Language;
import org.junit.jupiter.api.Test;

class LeagueOfLegendsClientBuilderTest {

    @Test
    public void test(){
        LeagueOfLegendsClient client = new LeagueOfLegendsClientBuilder().withChampionDownloader(Language.en_US).build();
    }

}