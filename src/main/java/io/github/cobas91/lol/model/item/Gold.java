package io.github.cobas91.lol.model.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gold {
    private int base;
    private int total;
    private int sell;
    private boolean purchasable;
}
