package models;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Feature {

    @JacksonXmlProperty(isAttribute = true)
    @SerializedName("Feature")
    private ArrayList<String> feature;


    public ArrayList<String> getFeature() {
        return feature;
    }

    public void setFeature(ArrayList<String> feature) {
        this.feature = feature;
    }

//    @Override
//    public String toString() {
//        return  feature.toString();
//    }
}
