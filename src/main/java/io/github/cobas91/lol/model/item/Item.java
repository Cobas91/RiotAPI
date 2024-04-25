package io.github.cobas91.lol.model.item;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Item {
    private Integer id;
    private String name;
    private Rune rune;
    private Gold gold;
    private String group;
    private String description;
    private String colloq;
    private String plaintext;
    private boolean consumed;
    private int stacks;
    private int depth;
    private boolean consumeOnFull;
    private ArrayList<Integer> from;
    private ArrayList<Integer> into;
    private int specialRecipe;
    private boolean inStore;
    private boolean hideFromAll;
    private String requiredChampion;
    private String requiredAlly;
    private Stats stats;
    private ArrayList<Object> tags;
    private Maps maps;
    private byte[] splash;
}
