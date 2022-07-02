package model;

import com.google.gson.annotations.SerializedName;

public class FactsModel {

    @SerializedName("text")
    String facts;

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    @SerializedName("source")
    String source;

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    @Override
    public String toString(){
        return " " + facts + " | " + "Source: " + source;
    }
}
