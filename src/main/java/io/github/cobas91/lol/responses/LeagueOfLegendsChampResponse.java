package io.github.cobas91.lol.responses;

import io.github.cobas91.lol.model.champion.Champion;
import lombok.Data;

import java.util.Map;

/**
 * The LeagueOfLegendsChampResponse class represents the response received when retrieving champion information from the League of Legends API.
 * It contains information about the type, format, version, and data of the champions.
 */
@Data
public class LeagueOfLegendsChampResponse {
    String type;
    String format;
    String version;
    Map<String, Champion> data;
}
