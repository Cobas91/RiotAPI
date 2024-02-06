package de.cobas.lol.model;

import lombok.Data;

@Data
public class ChampionSkinInfo {
    private String id;
    private String num;
    private String name;
    private String chromas;
    private byte[] image;
}
