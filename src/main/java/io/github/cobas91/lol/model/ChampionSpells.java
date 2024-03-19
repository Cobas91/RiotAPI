package io.github.cobas91.lol.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * The ChampionSpells class represents the spells of a champion in the game League of Legends.
 *
 * It contains information about each spell, including its ID, name, description, tooltip, level tip,
 * maximum rank, cooldown, cost, effect, variables, cost type, maximum ammunition, range, image, and resource.
 */
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
