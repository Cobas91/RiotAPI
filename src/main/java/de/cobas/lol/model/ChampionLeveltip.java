package de.cobas.lol.model;

import lombok.Data;

import java.util.List;

@Data
public class ChampionLeveltip {
    private List<String> label;
    private List<String> effect;
}
