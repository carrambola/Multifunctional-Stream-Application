package com.example.kurwailemozna.player;

import javafx.application.Platform;
import javafx.scene.web.WebView;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private WebView webView;
    private final String PLAYER_URL = "https://www.youtube.com/watch?v=";
    private AtomicInteger countdown = new AtomicInteger(0);
    private Timer timer;

    public void playSong(Song song) {
        webView.setVisible(true);
        webView.getEngine().load(PLAYER_URL + song.getYtCode());
        this.countdown.set(song.getDuration());
        countToNext();
    }

    public Player(WebView webView) {
        this.webView = webView;
    }

    public void countToNext() {

        Platform.runLater(() -> {
            timer = new Timer(1000, e -> {
                countdown.decrementAndGet();
                //System.out.println(countdown.get());
                Platform.runLater(() -> {
                    if (countdown.get() == 0 && Playlist.playlist.size() >= Playlist.currentSong + 1) {
                        Playlist.nextSong();
                        playSong(Playlist.playlist.get(Playlist.currentSong));
                    }
                });
                if (countdown.get() == 0) {
                    timer.stop();
                }
            });
            timer.start();
        });
    }
}
