package io.github.cobas91.lol.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    @JsonProperty("FlatHPPoolMod")
    public int flatHPPoolMod;
    public int rFlatHPModPerLevel;
    @JsonProperty("FlatMPPoolMod")
    public int flatMPPoolMod;
    public int rFlatMPModPerLevel;
    @JsonProperty("PercentHPPoolMod")
    public int percentHPPoolMod;
    @JsonProperty("PercentMPPoolMod")
    public int percentMPPoolMod;
    @JsonProperty("FlatHPRegenMod")
    public int flatHPRegenMod;
    public int rFlatHPRegenModPerLevel;
    @JsonProperty("PercentHPRegenMod")
    public int percentHPRegenMod;
    @JsonProperty("FlatMPRegenMod")
    public int flatMPRegenMod;
    public int rFlatMPRegenModPerLevel;
    @JsonProperty("PercentMPRegenMod")
    public int percentMPRegenMod;
    @JsonProperty("FlatArmorMod")
    public int flatArmorMod;
    public int rFlatArmorModPerLevel;
    @JsonProperty("PercentArmorMod")
    public int percentArmorMod;
    public int rFlatArmorPenetrationMod;
    public int rFlatArmorPenetrationModPerLevel;
    public int rPercentArmorPenetrationMod;
    public int rPercentArmorPenetrationModPerLevel;
    @JsonProperty("FlatPhysicalDamageMod")
    public int flatPhysicalDamageMod;
    public int rFlatPhysicalDamageModPerLevel;
    @JsonProperty("PercentPhysicalDamageMod")
    public int percentPhysicalDamageMod;
    @JsonProperty("FlatMagicDamageMod")
    public int flatMagicDamageMod;
    public int rFlatMagicDamageModPerLevel;
    @JsonProperty("PercentMagicDamageMod")
    public int percentMagicDamageMod;
    @JsonProperty("FlatMovementSpeedMod")
    public int flatMovementSpeedMod;
    public int rFlatMovementSpeedModPerLevel;
    @JsonProperty("PercentMovementSpeedMod")
    public int percentMovementSpeedMod;
    public int rPercentMovementSpeedModPerLevel;
    @JsonProperty("FlatAttackSpeedMod")
    public int flatAttackSpeedMod;
    @JsonProperty("PercentAttackSpeedMod")
    public int percentAttackSpeedMod;
    public int rPercentAttackSpeedModPerLevel;
    public int rFlatDodgeMod;
    public int rFlatDodgeModPerLevel;
    @JsonProperty("PercentDodgeMod")
    public int percentDodgeMod;
    @JsonProperty("FlatCritChanceMod")
    public int flatCritChanceMod;
    public int rFlatCritChanceModPerLevel;
    @JsonProperty("PercentCritChanceMod")
    public int percentCritChanceMod;
    @JsonProperty("FlatCritDamageMod")
    public int flatCritDamageMod;
    public int rFlatCritDamageModPerLevel;
    @JsonProperty("PercentCritDamageMod")
    public int percentCritDamageMod;
    @JsonProperty("FlatBlockMod")
    public int flatBlockMod;
    @JsonProperty("PercentBlockMod")
    public int percentBlockMod;
    @JsonProperty("FlatSpellBlockMod")
    public int flatSpellBlockMod;
    public int rFlatSpellBlockModPerLevel;
    @JsonProperty("PercentSpellBlockMod")
    public int percentSpellBlockMod;
    @JsonProperty("FlatEXPBonus")
    public int flatEXPBonus;
    @JsonProperty("PercentEXPBonus")
    public int percentEXPBonus;
    public int rPercentCooldownMod;
    public int rPercentCooldownModPerLevel;
    public int rFlatTimeDeadMod;
    public int rFlatTimeDeadModPerLevel;
    public int rPercentTimeDeadMod;
    public int rPercentTimeDeadModPerLevel;
    public int rFlatGoldPer10Mod;
    public int rFlatMagicPenetrationMod;
    public int rFlatMagicPenetrationModPerLevel;
    public int rPercentMagicPenetrationMod;
    public int rPercentMagicPenetrationModPerLevel;
    @JsonProperty("FlatEnergyRegenMod")
    public int flatEnergyRegenMod;
    public int rFlatEnergyRegenModPerLevel;
    @JsonProperty("FlatEnergyPoolMod")
    public int flatEnergyPoolMod;
    public int rFlatEnergyModPerLevel;
    @JsonProperty("PercentLifeStealMod")
    public int percentLifeStealMod;
    @JsonProperty("PercentSpellVampMod")
    public int percentSpellVampMod;
}
