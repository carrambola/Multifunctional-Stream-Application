package com.example.kurwailemozna.player;

import javafx.scene.control.Button;

public class Song {
    private String title;
    private String ytCode;
    private Integer duration;
    private Button button;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Integer getDuration() {
        return duration;
    }

    public Song(String title, String ytCode, Integer duration) {
        this.title = title;
        this.ytCode = ytCode;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYtCode() {
        return ytCode;
    }

    public void setYtCode(String ytCode) {
        this.ytCode = ytCode;
    }
}
