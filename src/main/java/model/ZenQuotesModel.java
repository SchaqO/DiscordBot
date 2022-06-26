package model;

import com.google.gson.annotations.SerializedName;

public class ZenQuotesModel {

    @SerializedName("a")
    private String author;

    @SerializedName("q")
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return " " + quote + " - " + author;
    }
}
