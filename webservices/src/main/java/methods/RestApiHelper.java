package methods;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestApiHelper {


    public static RestResponse performHttpGet(String url, Map<String, String> headers) {
        try {
            return performHttpGet(new URI(url), headers);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static RestResponse performHttpGet(URI uri, Map<String, String> headers) {
        HttpGet httpGet = new HttpGet(uri);

        if (headers != null) {
            headers.forEach((k, v) -> httpGet.addHeader(k, v));

        }
        return getRestResponse(httpGet);
    }

//    public static RestResponse performHttpGet1(String uri, Map<String, String> headers) {
//        HttpGet httpGet = new HttpGet(uri);
//        HttpResponse httpResponse = null;
//        if (headers != null) {
//            headers.forEach((k, v) -> httpGet.addHeader(k, v));
//
//        }
//        try {
//            Response response = Request.Get(uri).execute();
//            httpResponse = response.returnResponse();
//
//
//            return new RestResponse(httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
//
//        } catch (Exception e) {
//            if (e instanceof HttpResponseException) {
//                return new RestResponse(httpResponse.getStatusLine().getStatusCode(),
//                        e.getMessage());
//            }
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }



    public static RestResponse performHttpPost(String url, Map<String, String> headers, Object content, ContentType type) throws UnsupportedEncodingException {

        HttpPost httpPost = new HttpPost(url);

        if (headers != null) {
            headers.forEach((k, v) -> httpPost.addHeader(k, v));
        }
        httpPost.setEntity(getHttpEntity(content, type));

        return getRestResponse(httpPost);

    }

    public static RestResponse performHttpPost(URI uri, Map<String, String> headers, Object content, ContentType type) throws UnsupportedEncodingException {

        try {
            return performHttpPost(uri, headers, content, type);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    private static RestResponse getRestResponse(HttpRequestBase httpRequest) {
        CloseableHttpResponse response = null;

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            response = client.execute(httpRequest);

            ResponseHandler<String> responseBody = new BasicResponseHandler();

            return new RestResponse(response.getStatusLine().getStatusCode(),
                    responseBody.handleResponse(response));

        } catch (Exception e) {
            if (e instanceof HttpResponseException) {
                return new RestResponse(response.getStatusLine().getStatusCode(),
                        e.getMessage());
            }
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static HttpEntity getHttpEntity(Object content, ContentType type) {
        if (content instanceof String) {
            return new StringEntity((String) content, type);
        } else if (content instanceof File) {
            return new FileEntity((File) content, type);
        }else {
            throw new RuntimeException("Entity type not found");
        }
    }

    public static RestResponse performHttpDelete(String url) {

        HttpDelete delete = new HttpDelete(url);

        return getRestResponse(delete);


    }
}
