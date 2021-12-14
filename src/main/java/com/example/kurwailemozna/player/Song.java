package com.example.kurwailemozna.player;

public class Song {
    private String title;
    private String ytCode;

    public Song(String title, String ytCode) {
        this.title = title;
        this.ytCode = ytCode;
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
