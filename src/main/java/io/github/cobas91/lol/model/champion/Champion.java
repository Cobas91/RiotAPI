package io.github.cobas91.lol.model.champion;

import lombok.Data;

import java.util.List;

/**
 * Represents a champion in the game League of Legends.
 */
@Data
public class Champion {
    private String version;
    private String id;
    private String key;
    private String name;
    private String title;
    private String blurb;
    private byte[] championIcon;
    private ChampionInfo info;
    private ChampionImage image;
    private List<String> tags;
    private String partype;
    private ChampionStats stats;
    private List<ChampionSkinInfo> skins;
    private String lore;
    private List<String> allytips;
    private List<String> enemytips;
    private List<ChampionSpells> spells;
    private ChampionPassive passive;
}
