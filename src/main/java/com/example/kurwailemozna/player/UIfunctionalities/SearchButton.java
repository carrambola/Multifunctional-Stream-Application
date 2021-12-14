package com.example.kurwailemozna.player.UIfunctionalities;

import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.google.GoogleSearch;
import javafx.scene.web.WebView;

import java.util.Map;

public class SearchButton implements Button{
    WebView webView;
    @Override
    public void onClick(Map<String, String> parameters) {
        GoogleSearch googleSearch = new GoogleSearch();
        webView.setVisible(true);
        webView.getEngine().load("https://www.youtube.com/watch?v=" + googleSearch
                .requestSetup(parameters.get("vidId"))
                .executeRequest()
                .getSpecificData("vidId"));
        Playlist.addToQueue(googleSearch.getSpecificData("title"), googleSearch.getSpecificData("vidId"));
    }
    public SearchButton setWebView(WebView webView) {
        this.webView = webView;
        return this;
    }
}
