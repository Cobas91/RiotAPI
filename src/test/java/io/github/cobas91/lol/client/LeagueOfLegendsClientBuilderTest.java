package io.github.cobas91.lol.client;

import io.github.cobas91.RiotSettings;
import io.github.cobas91.enums.Language;
import io.github.cobas91.enums.RiotRegion;
import org.junit.jupiter.api.Test;

class LeagueOfLegendsClientBuilderTest {
    @Test
    public void test(){
        RiotSettings settings = RiotSettings.builder().build();
        LeagueOfLegendsClient client = LeagueOfLegendsClient.builder(settings).build();
    }

}