package de.cobas.lol.responses;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SummonerInformationResponse {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private int profileIconId;
    private BigInteger revisionDate;
    private int summonerLevel;
}
