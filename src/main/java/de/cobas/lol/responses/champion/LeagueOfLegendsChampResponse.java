package de.cobas.lol.responses.champion;

import lombok.Data;

import java.util.Map;

@Data
public class LeagueOfLegendsChampResponse {
    String type;
    String format;
    String version;
    Map<String, Champion> data;
}
