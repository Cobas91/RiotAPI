package io.github.cobas91.lol.model;

import lombok.Data;

/**
 * Represents information about a skin for a champion in the game League of Legends.
 */
@Data
public class ChampionSkinInfo {
    private String id;
    private String num;
    private String name;
    private String chromas;
    private byte[] image;
}
