package io.github.cobas91.lol.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Maps {
    @JsonProperty("1")
    private boolean _1;
    @JsonProperty("8")
    private boolean _8;
    @JsonProperty("10")
    private boolean _10;
    @JsonProperty("12")
    private boolean _12;
}
