package de.cobas.lol;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StaticApiDownloader {
    static Logger log = Logger.getLogger(StaticApiDownloader.class);
    static final HttpClient client = HttpClient.newHttpClient();
    static final ObjectMapper mapper = new ObjectMapper();

    public static String[] downloadVersionNumbers() {
        try {
            URI uri = new URI(RiotApiUrl.VERSION.toString());
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                String jsonString = response.body();
                String[] versions = mapper.readValue(jsonString, String[].class);
                return versions;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new String[0];
    }
}
