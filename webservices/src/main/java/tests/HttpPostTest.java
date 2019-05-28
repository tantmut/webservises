package tests;

import com.fasterxml.jackson.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import methods.RestApiHelper;
import methods.RestResponse;
import models.ComputerInfo;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.codehaus.jackson.map.DeserializationConfig;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpPostTest {

    @Test
    public void testPostAddJson() throws UnsupportedEncodingException {

        String id = new Random().nextInt(500) + "";
        String url = "http://localhost:8080/laptop-bag/webapi/api/add";
        String pathname = "src/main/java/jsonFiles/addProduct";


        String body = "{\n" +
                "\t\"BrandName\": \"Nokia\",\n" +
                "\t\"Features\": {\n" +
                "\t\t\"Feature\": [\"16GB RAM\",\n" +
                "\t\t\"1TB Hard Drive\"]\n" +
                "\t},\n" +
                "\t\"Id\":" + id + ",\n" +
                "\t\"LaptopName\": \"Planet\"\n" +
                "}\n";

        ClassLoader classLoader = getClass().getClassLoader();

//        File file = new File(pathname);
//
//        FileEntity body = new FileEntity(file);

        Map<String, String> headers = new HashMap<>();

        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");

        RestResponse restResponse = RestApiHelper.performHttpPost(url, headers, body, ContentType.APPLICATION_JSON);

        assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());

        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.serializeNulls().setPrettyPrinting().create();

        ComputerInfo computerInfo = gson.fromJson(restResponse.getResponseBody(), ComputerInfo.class);

        System.out.println(restResponse.getResponseBody());

        assertEquals("Nokia", computerInfo.getBrandName());
    }

    @Test
    public void testPostAddXml() throws IOException, JAXBException {

        String id = new Random().nextInt(500) + "";
        String url = "http://localhost:8080/laptop-bag/webapi/api/add";
        String pathname = "src/main/java/jsonFiles/addProduct";


        String body = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Laptop>\n" +
                "    <BrandName>Nokia</BrandName>\n" +
                "    <Features>\n" +
                "        <Feature>16GB RAM</Feature>\n" +
                "        <Feature>1TB Hard Drive</Feature>\n" +
                "    </Features>\n" +
                "    <Id>168</Id>\n" +
                "    <LaptopName>Planet</LaptopName>\n" +
                "</Laptop>";

        ClassLoader classLoader = getClass().getClassLoader();

//        File file = new File(pathname);
//
//        FileEntity body = new FileEntity(file);

        Map<String, String> headers = new HashMap<>();

        headers.put("Accept", "application/xml");
        headers.put("Content-Type", "application/xml");

        RestResponse restResponse = RestApiHelper.performHttpPost(url, headers, body, ContentType.APPLICATION_ATOM_XML);

        assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());

//        GsonBuilder builder = new GsonBuilder();
//
//        Gson gson = builder.serializeNulls().setPrettyPrinting().create();
//
//        ComputerInfo computerInfo = gson.fromJson(restResponse.getResponseBody(), ComputerInfo.class);

        XmlMapper maper = new XmlMapper();
        maper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//        maper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        ComputerInfo computerInfo = maper.readValue(restResponse.getResponseBody(), ComputerInfo.class);

        System.out.println(computerInfo.toString());

        assertEquals("Nokia", computerInfo.getBrandName());
    }
}
