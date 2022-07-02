package api;

import com.google.gson.Gson;
import model.FactsModel;
import model.ZenQuotesModel;
import utils.Util;

public class Facts {

    //Util util = new Util();

    public String randomFact() throws Exception {

        String json = Util.readUrl("https://www.thefact.space/random");

        Gson gson = new Gson();
        FactsModel factsModel = gson.fromJson(json, FactsModel.class);

        System.out.println(factsModel.toString());
        return factsModel.toString();

    }
}
