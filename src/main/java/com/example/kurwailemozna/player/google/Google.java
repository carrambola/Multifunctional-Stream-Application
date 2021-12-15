package com.example.kurwailemozna.player.google;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class Google implements GoogleAPI{
    protected final String API_KEY = "&key=AIzaSyBdelFEYrjNYoAw8WjArp0CLmwLjVhJR3A";
    protected final String SEARCH_URL= "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=relevance&q=";
    protected final String VIDEO_URL = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails&id=";
    protected String url;
    protected Document doc;


    @Override
    public GoogleAPI executeRequest() {
        try {
            doc = Jsoup.connect(url).timeout(10 * 1000).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
    @Override
    public void flush() {
        url = null;
    }

}
