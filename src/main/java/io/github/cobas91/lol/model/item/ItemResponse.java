package io.github.cobas91.lol.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ItemResponse {
    private String type;
    private String version;
    @JsonProperty("basic")
    private Item exampleItem;
    private Map<Integer, Item> data;
    private List<ItemGroup> groups;
}
