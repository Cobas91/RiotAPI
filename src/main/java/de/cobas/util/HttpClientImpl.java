package de.cobas.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class HttpClientImpl {
    public Logger log;
    public static Logger staticLogger = Logger.getLogger("");
    public static final HttpClient httpClient = HttpClient.newHttpClient();
    public static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public HttpClientImpl(Class<?> implementingClass) {
        this.log = Logger.getLogger(implementingClass);
        staticLogger= this.log;
    }

    public static HttpRequest getForUri(URI uri){
        return HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
    }

    public static <T> T sendRequest(HttpRequest request, Class<T> clazz){
        try {
            staticLogger.info("Sending Request to: "+request.uri());
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
