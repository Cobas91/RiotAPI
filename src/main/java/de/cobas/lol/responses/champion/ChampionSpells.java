package de.cobas.lol.responses.champion;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ChampionSpells {
    private String id;
    private String name;
    private String description;
    private String tooltip;
    private ChampionLeveltip leveltip;
    private int maxrank;
    private List<Integer> cooldown;
    private String cooldownBurn;
    private List<Integer> cost;
    private String costBurn;
    private Object datavalues; //TODO Herrausfinden was hier drin stecken kann
    private List<List<Integer>> effect;
    private List<String> effectBurn;
    private List<String> vars; //TODO Herrausfinden was hier drin stecken kann
    private String costType;
    private String maxammo;
    private List<BigInteger> range;
    private String rangeBurn;
    private LeagueOfLegendsImage image;
    private String resource;
}
