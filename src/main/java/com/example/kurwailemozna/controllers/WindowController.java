package com.example.kurwailemozna.controllers;

import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.UIfunctionalities.SearchButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class WindowController implements Initializable {
    String title;

    @FXML
    private WebView webView;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    public void onSearchButtonClick() {
        SearchButton srcBut = new SearchButton();
        Map<String, String> map = new HashMap();
        map.put("vidId", searchField.getText());
        srcBut.setWebView(webView).onClick(map);

    }

    public void onNextButtonClick(){

    }

    public void onClearButtonClick(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}