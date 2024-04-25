package io.github.cobas91.lol.model.match;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Objectives{
    public Baron baron;
    public Champion champion;
    public Dragon dragon;
    public Horde horde;
    public Inhibitor inhibitor;
    public RiftHerald riftHerald;
    public Tower tower;
}
