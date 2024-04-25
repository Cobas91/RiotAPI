package io.github.cobas91.enums;

import lombok.Getter;

/**
 * Enumeration class representing the regions in Riot Games.
 */
@Getter
public enum RiotRegion {
    EUW1("europe"),
    NA1("northeast");
    private String urlParameter;

    RiotRegion(String urlParameter) {
        this.urlParameter = urlParameter;
    }
}
