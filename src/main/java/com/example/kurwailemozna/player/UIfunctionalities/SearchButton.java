package com.example.kurwailemozna.player.UIfunctionalities;

import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.Song;
import com.example.kurwailemozna.player.google.GoogleSearch;
import com.example.kurwailemozna.player.google.GoogleVideo;
import javafx.scene.web.WebView;

import java.util.Map;

public class SearchButton extends Button{
    Boolean validated;
    public Song onClick(String searchPhrase) {
        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch
                .requestSetup(searchPhrase)
                .executeRequest();
        GoogleVideo videoSearch = new GoogleVideo();
        videoSearch.requestSetup(googleSearch.getSpecificData("vidId")).executeRequest();
        return new Song(googleSearch.getSpecificData("title"), googleSearch.getSpecificData("vidId"), Integer.parseInt(videoSearch.getSpecificData("length")));
    }
}
