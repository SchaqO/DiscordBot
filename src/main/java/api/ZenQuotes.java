package api;

import com.google.gson.*;
import model.ZenQuotesModel;
import utils.Util;


public class ZenQuotes {

    //Util util = new Util();

    public String parseURL() throws Exception {

        String json = Util.readUrl("https://zenquotes.io/api/random");
        Gson gson = new Gson();

        ZenQuotesModel[] model = gson.fromJson(json, ZenQuotesModel[].class);

        for(ZenQuotesModel zenQuotesModel : model) {
            System.out.println(zenQuotesModel);
            return zenQuotesModel.toString();
        }
        return "null";
    }
}
