package de.cobas.lol.responses.champion;

import lombok.Data;

import java.util.List;

@Data
public class ChampionLeveltip {
    private List<String> label;
    private List<String> effect;
}
