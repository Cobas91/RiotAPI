package io.github.cobas91.lol.model;

import lombok.Data;

/**
 * The LeagueOfLegendsImage class represents an image associated with a League of Legends object.
 * It contains information about the image, such as its file name, position within a sprite, width, and height.
 */
@Data
public class LeagueOfLegendsImage {
    private String full;
    private String sprite;
    private String group;
    private String x;
    private String y;
    private String w;
    private String h;
}
