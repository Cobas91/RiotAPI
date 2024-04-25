package io.github.cobas91.lol.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Missions{
    @JsonProperty("PlayerScore0")
    public int playerScore0;
    @JsonProperty("PlayerScore1")
    public int playerScore1;
    @JsonProperty("PlayerScore10")
    public int playerScore10;
    @JsonProperty("PlayerScore11")
    public int playerScore11;
    @JsonProperty("PlayerScore2")
    public int playerScore2;
    @JsonProperty("PlayerScore3")
    public int playerScore3;
    @JsonProperty("PlayerScore4")
    public int playerScore4;
    @JsonProperty("PlayerScore5")
    public int playerScore5;
    @JsonProperty("PlayerScore6")
    public int playerScore6;
    @JsonProperty("PlayerScore7")
    public int playerScore7;
    @JsonProperty("PlayerScore8")
    public int playerScore8;
    @JsonProperty("PlayerScore9")
    public int playerScore9;
}
