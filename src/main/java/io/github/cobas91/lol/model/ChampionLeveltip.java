package io.github.cobas91.lol.model;

import lombok.Data;

import java.util.List;

/**
 * The ChampionLeveltip class represents the level tip information for a champion spell.
 * It contains labels and effects that provide guidance on how to use and improve the spell at different champion levels.
 */
@Data
public class ChampionLeveltip {
    private List<String> label;
    private List<String> effect;
}
