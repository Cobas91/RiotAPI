package io.github.cobas91.lol.model.summoner;

import lombok.Data;

import java.math.BigInteger;

/**
 * Represents the response object containing summoner information.
 */
@Data
public class Summoner {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private int profileIconId;
    private BigInteger revisionDate;
    private int summonerLevel;
}
