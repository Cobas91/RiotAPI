package de.cobas.lol.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChampionStats {
    private double hp;
    @JsonProperty("hpperlevel")
    private double hpPerLevel;
    private double mp;
    @JsonProperty("mpperlevel")
    private double mpPerLevel;
    private double movespeed;
    private double armor;
    private double armorperlevel;
    private double spellblock;
    private double spellblockperlevel;
    private double attackrange;
    private double hpregen;
    private double hpregenperlevel;
    private double mpregen;
    private double mpregenperlevel;
    private double crit;
    private double critperlevel;
    private double attackdamage;
    private double attackdamageperlevel;
    private double attackspeedperlevel;
    private double attackspeed;
}
