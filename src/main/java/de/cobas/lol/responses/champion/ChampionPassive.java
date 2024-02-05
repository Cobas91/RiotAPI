package de.cobas.lol.responses.champion;

import lombok.Data;

import java.util.List;

@Data
public class ChampionPassive {
    private String name;
    private String description;
    private LeagueOfLegendsImage image;
    private List<String> recommended;
}
