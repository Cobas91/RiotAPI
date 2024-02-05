package de.cobas.lol.responses.champion;

import lombok.Data;

import java.util.List;

@Data
public class Champion {
    private String version;
    private String id;
    private String key;
    private String name;
    private String title;
    private String blurb;
    private ChampionInfo info;
    private LeagueOfLegendsImage image;
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
