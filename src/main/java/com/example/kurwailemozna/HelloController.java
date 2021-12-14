package com.example.kurwailemozna;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    String title;

    @FXML
    private WebView webView;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    public void onSearchButtonClick() {
        title = searchField.getText();
        title = title.replace(" ", "+");
        String u = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=viewCount&q=" + title + "&key=AIzaSyCd2rH36V2NhNmzYLTIvni4IKdJuJYxffI";
        Document doc = null;
        try {
            doc = Jsoup.connect(u).timeout(10 * 1000).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String getJson = doc.text();
        JSONObject object = new JSONObject(getJson);
        JSONArray array = object.getJSONArray("items");
        String vidId = array.getJSONObject(0).getJSONObject( "id").getString("videoId");
        System.out.println(vidId);

        webView.setVisible(true);
        webView.getEngine().load("https://www.youtube.com//watch?v=" + vidId);
        System.out.println(title);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}