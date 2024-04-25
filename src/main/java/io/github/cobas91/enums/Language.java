package io.github.cobas91.enums;

/**
 * Enumeration class representing the supported languages.
 */
public enum Language {
    en_US("English (United States)"),
    cs_CZ("Czech (Czech Republic)"),
    de_DE("German (Germany)"),
    el_GR("Greek (Greece)"),
    en_AU("English (Australia)"),
    en_GB("English (United Kingdom)"),
    en_PH("English (Republic of the Philippines)"),
    en_SG("English (Singapore)"),
    es_AR("Spanish (Argentina)"),
    es_ES("Spanish (Spain)"),
    es_MX("Spanish (Mexico)"),
    fr_FR("French (France)"),
    hu_HU("Hungarian (Hungary)"),
    it_IT("Italian (Italy)"),
    ja_JP("Japanese (Japan)"),
    ko_KR("Korean (Korea)"),
    pl_PL("Polish (Poland)"),
    pt_BR("Portuguese (Brazil)"),
    ro_RO("Romanian (Romania)"),
    ru_RU("Russian (Russia)"),
    th_TH("Thai (Thailand)"),
    tr_TR("Turkish (Turkey)"),
    vi_VN("Vietnamese (Viet Nam)"),
    zh_CN("Chinese (China)"),
    zh_MY("Chinese (Malaysia)"),
    ms_MY("Malay (Malaysia)"),
    zh_TW("Chinese (Taiwan)"),
    id_ID("Indonesian (Indonesia)");
    private final String name;

        Language(String name) {
                this.name = name;
        }
}
