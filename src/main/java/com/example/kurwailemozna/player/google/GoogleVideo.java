package com.example.kurwailemozna.player.google;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class GoogleVideo extends Google{

    @Override
    public GoogleAPI requestSetup(String searchObj) {
        searchObj = searchObj.replace(" ", "+");
        url = VIDEO_URL + searchObj + API_KEY;
        System.out.println(url);
        return this;
    }

    @Override
    public String getSpecificData(String marker) {
        switch (marker){
            case "length":
                return getVideoLength();

            default:
                return null;
        }
    }

    private String getVideoLength(){
        this.flush();
        return isoDecoder(new JSONObject(doc.text()).getJSONArray("items").getJSONObject(0).getJSONObject("contentDetails").getString("duration"));
    }
    private String isoDecoder(String toDecode){
        Duration duration = Duration.parse(toDecode); // 12 hours
        System.out.println(String.valueOf(duration.getSeconds()));
        return String.valueOf(duration.getSeconds());
    }
}
