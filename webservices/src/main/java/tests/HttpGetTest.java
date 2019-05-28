package tests;


import methods.RestApiHelper;
import methods.RestResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpGetTest {

    public static void main(String[] args) {

        String s = "http://localhost:8080/laptop-bag/webapi/api/ping/hello";

        HttpPost post = new HttpPost(s);

        try(CloseableHttpClient client = HttpClientBuilder.create().build()){

            post.addHeader("Content-Type", "application/json");
            post.addHeader("Accept", "application/json");


        } catch (IOException e) {
            e.printStackTrace();
        }

        RestResponse restResponse = RestApiHelper.performHttpGet(s, null);

        System.out.println(restResponse.getStatusCode());
        System.out.println(restResponse.getResponseBody());


    }
}
