package io.github.cobas91.lol.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemGroup {
    private String id;
    @JsonProperty("MaxGroupOwnable")
    private String maxGroupOwnable;
}
