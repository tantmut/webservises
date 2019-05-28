package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import methods.ReadFIlesUtils;
import methods.RestApiHelper;
import methods.RestResponse;
import models.ComputerInfo;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGetMethod {

    @Test
    public void testGetPingAlive() {
        String url = "http://localhost:8080/laptop-bag/webapi/api/ping/hello";
        String body = "Hi! hello";

        RestResponse restResponse = RestApiHelper.performHttpGet(url, null);

        assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
        assertEquals(body, restResponse.getResponseBody());

        System.out.println(restResponse.getResponseBody());
    }

    @Test
    public void testGetAll() {
        String url = "http://localhost:8080/laptop-bag/webapi/api/all";
        Map<String, String> headers = new HashMap<>();

        headers.put("Accept", "application/json");

        RestResponse restResponse = RestApiHelper.performHttpGet(url, headers);

        assertTrue(HttpStatus.SC_OK == restResponse.getStatusCode() ||
                HttpStatus.SC_NO_CONTENT == restResponse.getStatusCode());

        System.out.println(restResponse.getResponseBody());

    }

    @Test
    public void testGetFindWithId() {
        String url = "http://localhost:8080/laptop-bag/webapi/api/find/128";

        Map<String, String> headers = new HashMap<>();

        headers.put("Accept", "application/json");

        RestResponse restResponse = RestApiHelper.performHttpGet(url, headers);
        assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());

        System.out.println(restResponse.getResponseBody());

        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.serializeNulls().setPrettyPrinting().create();
        ComputerInfo responseBody = gson.fromJson(restResponse.getResponseBody(), ComputerInfo.class);

        assertEquals("Lenovo", responseBody.getBrandName());
        assertEquals("128", responseBody.getId());
        assertEquals("Idea", responseBody.getLaptopName());
        assertEquals(Arrays.asList("8GB RAM", "1TB Hard Drive"), responseBody.getFeatures().getFeature());
    }




}
