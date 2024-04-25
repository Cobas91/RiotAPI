package io.github.cobas91.lol.model.match;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Style{
    public String description;
    public List<Selection> selections;
    public int style;
}
