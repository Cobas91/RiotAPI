package io.github.cobas91.lol.model.match;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info{
    public String endOfGameResult;
    public long gameCreation;
    public int gameDuration;
    public long gameEndTimestamp;
    public long gameId;
    public String gameMode;
    public String gameName;
    public long gameStartTimestamp;
    public String gameType;
    public String gameVersion;
    public int mapId;
    public List<Participant> participants;
    public String platformId;
    public int queueId;
    public ArrayList<Team> teams;
    public String tournamentCode;
}
