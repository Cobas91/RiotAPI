package de.cobas.lol.responses.champion;

import de.cobas.lol.model.Champion;
import lombok.Data;

import java.util.Map;

@Data
public class LeagueOfLegendsChampResponse {
    String type;
    String format;
    String version;
    Map<String, Champion> data;
}
