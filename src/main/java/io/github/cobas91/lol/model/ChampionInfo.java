package io.github.cobas91.lol.model;

import lombok.Data;

/**
 * Represents the information of a champion in the game League of Legends.
 */
@Data
public class ChampionInfo {
    private int attack;
    private int defense;
    private int magic;
    private int difficulty;
}
