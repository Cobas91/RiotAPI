package io.github.cobas91.lol.model.match;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team{
    public List<Ban> bans;
    public Objectives objectives;
    public int teamId;
    public boolean win;
}
