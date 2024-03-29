package io.github.cobas91.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/******************************************************************************
 * Class: HttpClientImpl
 * Author:
 * Description: This abstract class provides a basic implementation for making HTTP requests
 *              using the Java HttpClient library. It contains methods for sending GET requests,
 *              handling responses, and configuring the HTTP client.
 ******************************************************************************/
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

    /**
     * Retrieves an HTTP request object for the given URI with the necessary header information.
     * The "X-Riot-Token" header is set using the token value provided in the containing class.
     *
     * @param uri the URI to send the request to
     * @return an instance of HttpRequest with the URI and header information set
     */
    public static HttpRequest getForUri(URI uri){
        return HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Riot-Token", token)
                .GET()
                .build();
    }

    /**
     * Sends an HTTP request and returns the response body deserialized into the specified class.
     *
     * @param request the HttpRequest to send
     * @param clazz the Class object representing the desired type to deserialize the response body into
     * @param <T> the type of the response body
     * @return an instance of the specified class with the response body deserialized into it
     * @throws RuntimeException if an error occurs while sending the request or deserializing the response body
     */
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
