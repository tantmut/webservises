package tests;

import methods.RestApiHelper;
import methods.RestResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpDeleteTest {

    public static void main(String[] args) {

        String id = "0";
        String url = "http://localhost:8080/laptop-bag/webapi/api/delete/" + id;


        RestResponse restResponse = RestApiHelper.performHttpDelete(url);

        System.out.println(restResponse.getStatusCode());
        System.out.println(restResponse.getResponseBody());


    }
}
