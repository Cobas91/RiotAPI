package io.github.cobas91.lol.model;

import lombok.Data;

import java.util.List;

/**
 * The ChampionPassive class represents the passive ability of a champion in the game League of Legends.
 *
 * It contains information about the passive ability, including its name, description, recommended items, and image.
 */
@Data
public class ChampionPassive {
    private String name;
    private String description;
    private LeagueOfLegendsImage image;
    private List<String> recommended;
}
