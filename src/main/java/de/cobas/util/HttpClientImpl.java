package de.cobas.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public abstract class HttpClientImpl {
    public Logger log;
    public static Logger staticLogger = Logger.getLogger("");
    public static final HttpClient httpClient = HttpClient.newHttpClient();
    public static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static String token = "";

    public HttpClientImpl(Class<?> implementingClass) {
        this.log = Logger.getLogger(implementingClass);
        staticLogger= this.log;
    }
    public HttpClientImpl(Class<?> implementingClass, String apiToken) {
        this.log = Logger.getLogger(implementingClass);
        staticLogger= this.log;
        token = apiToken;
    }

    public static HttpRequest getForUri(URI uri){
        return HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Riot-Token", token)
                .GET()
                .build();
    }

    public static <T> T sendRequest(HttpRequest request, Class<T> clazz){
        try {
            staticLogger.info("Sending Request to: "+request.uri());
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                return mapper.readValue(response.body(), clazz);
            }else{
                staticLogger.warn("Request failed with status code: "+response.statusCode());
                return mapper.readValue(response.body(), clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
