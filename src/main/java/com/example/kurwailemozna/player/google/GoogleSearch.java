package com.example.kurwailemozna.player.google;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GoogleSearch implements GoogleAPI {
    private String url;
    private Document doc;

    @Override
    public GoogleAPI requestSetup(String searchObj) {
        searchObj = searchObj.replace(" ", "+");
        url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=relevance&q=" + searchObj + "&key=AIzaSyCd2rH36V2NhNmzYLTIvni4IKdJuJYxffI";
        System.out.println(url);
        return this;
    }

    private String getVidIdAndFlush() {
        JSONObject object = new JSONObject(doc.text());
        JSONArray array = object.getJSONArray("items");
        this.flush();
        return array.getJSONObject(0).getJSONObject( "id").getString("videoId");
    }

    private String getTitleAndFlush(){
        JSONObject object = new JSONObject(doc.text());
        JSONArray array= object.getJSONArray("items");
        this.flush();
        return array.getJSONObject(0).getJSONObject( "snippet").getString("title");
    }

    public String getSpecificData(String marker){
        switch(marker){
            case "vidId":
                return getVidIdAndFlush();
            case "title":
                return getTitleAndFlush();
            default:
                return null;
        }
    }

    @Override
    public void flush() {
        url = null;
    }
}
