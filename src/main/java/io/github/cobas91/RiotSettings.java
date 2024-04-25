package io.github.cobas91;

import io.github.cobas91.enums.Language;
import io.github.cobas91.enums.RiotRegion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RiotSettings {
    private String apiToken;
    private String patchVersion;
    private Language language;
    private RiotRegion region;
}
