package api;

import com.google.gson.*;
import model.ZenQuotesModel;


import java.io.*;
import java.net.URL;


public class ZenQuotes {

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public String parseURL() throws Exception {

        String json = readUrl("https://zenquotes.io/api/random");
        Gson gson = new Gson();

        ZenQuotesModel[] model = gson.fromJson(json, ZenQuotesModel[].class);

        for(ZenQuotesModel zenQuotesModel : model) {
            System.out.println(zenQuotesModel);
            return zenQuotesModel.toString();
        }
        return "null";
    }
}
