package io.github.cobas91.lol.model.match;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaData{
    public String dataVersion;
    public String matchId;
    public ArrayList<String> participants;
}
