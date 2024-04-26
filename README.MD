# Java RiotAPI Library
You can use this Library to fetch Data from the official RiotApi.

![Riot Games](https://img.shields.io/badge/riotgames-D32936.svg?style=for-the-badge&logo=riotgames&logoColor=white)
![GitHub Release](https://img.shields.io/github/v/release/Cobas91/RiotAPI)
<!-- TOC -->
* [Java RiotAPI Library](#java-riotapi-library)
  * [Supported Games](#supported-games)
  * [General Usage](#general-usage)
    * [League of Legends](#league-of-legends)
    * [Valorant (TBD)](#valorant-tbd)
    * [Teamfight Tactics (TBD)](#teamfight-tactics-tbd)
<!-- TOC -->


## Supported Games
- League of Legends
- Valorant (TBD)
- Teamfight Tactics (TBD)

## General Usage
Add the repository to your project
```xml
<project>
  ...
    <repositories>
        <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/cobas91/RiotApi</url>
        </repository>     
    </repositories>
</project>
```

Add the dependency to your project, replace {VERSION} with the current release
```xml
<dependencies>
    <dependency>
        <groupId>io.github.cobas91</groupId>
        <artifactId>riotapi</artifactId>
        <version>{VERSION}</version>
    </dependency>  
</dependencies>
```

### League of Legends

```Java
//Get your API Token from the Official RiotApi Website. You have to register an Application to get one.
RiotSettings settings = RiotSettings.builder().language(Language.de_DE).region(RiotRegion.EUW1).apiToken("TOKEN HERE").build();

LeagueOfLegendsClient client = LeagueOfLegendsClient.builder(settings).withChampionDownloader().withSummonerDownloader().withMatchDownloader().build();
List<Champion> allChampions = client.getChampionDownloader().getAllChampions();

List<Item> allItems = client.getItemDownloader().getAllItems();
```
[JavaDocs](https://cobas91.github.io/RiotAPI/)

### Valorant (TBD)
(TBD)
### Teamfight Tactics (TBD)
(TBD)