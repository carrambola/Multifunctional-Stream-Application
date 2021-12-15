package com.example.kurwailemozna.controllers;

import com.example.kurwailemozna.player.Player;
import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.Song;
import com.example.kurwailemozna.player.UIfunctionalities.AddToQueueButton;
import com.example.kurwailemozna.player.UIfunctionalities.ClearQueueButton;
import com.example.kurwailemozna.player.UIfunctionalities.NextButton;
import com.example.kurwailemozna.player.UIfunctionalities.SearchButton;
import com.example.kurwailemozna.player.google.GoogleVideo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class WindowController implements Initializable {
    public String title;
    public Song currSong;
    private Player player;

    @FXML
    private WebView webView;

    @FXML
    private Button searchButton;

    @FXML
    private Button addToQueueButton;

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> listView;

    public void onSearchButtonClick() {
        SearchButton srcBut = new SearchButton();
        currSong = srcBut.onClick(searchField.getText());
    }

    public void onAddToQueueButtonClick() {
        AddToQueueButton addBut = new AddToQueueButton();
        addBut.playFirst(player, currSong);
        addBut.onClick(currSong);
        listView.setItems(Playlist.songToTitleConversion());
    }

    public void onNextButtonClick() {
        NextButton nextBut = new NextButton();
        nextBut.onClick();
        player.playSong(Playlist.getQueue().get(Playlist.currentSong));
    }

    public void onClearButtonClick() {
        ClearQueueButton clrBut = new ClearQueueButton();
        clrBut.onClick();
        listView.setItems(Playlist.songToTitleConversion());
        if (listView.getSelectionModel().getSelectedItem() != null){
            Playlist.getQueue().forEach(song -> {
                if (song.getTitle().equals(listView.getSelectionModel().getSelectedItem())) {
                    Playlist.currentSong = Playlist.getQueue().indexOf(song);
                    System.out.println(Playlist.currentSong);
                }
            });
            player.playSong(Playlist.getQueue().get(Playlist.currentSong));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player = new Player(webView);
    }
}