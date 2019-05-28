package models;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "ComputerInfo")
public class ComputerInfo {

    @JacksonXmlProperty(isAttribute = true)
    @SerializedName("BrandName")
    @XmlElement(name = "BrandName")
    private String brandName;

    @JacksonXmlProperty(isAttribute = true)
    @SerializedName("Id")
    @XmlElement(name = "Id")
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    @SerializedName("LaptopName")
    private String laptopName;

    @JacksonXmlProperty(isAttribute = true)
    @SerializedName("Features")
    private Feature features;

    @XmlElement(name = "BrandName")
    public String getBrandName() {
        return brandName;
    }

    public String getId() {
        return id;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public Feature getFeatures() {
        return features;
    }


    @Override
    public String toString() {
        return "ComputerInfo{" +
                "brandName='" + brandName + '\'' +
                ", id='" + id + '\'' +
                ", laptopName='" + laptopName + '\'' +
                ", features=" + features +
                '}';
    }
}


