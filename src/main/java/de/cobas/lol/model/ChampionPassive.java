package de.cobas.lol.model;

import lombok.Data;

import java.util.List;

@Data
public class ChampionPassive {
    private String name;
    private String description;
    private LeagueOfLegendsImage image;
    private List<String> recommended;
}
