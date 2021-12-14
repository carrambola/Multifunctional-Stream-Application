package com.example.kurwailemozna.player.google;

public interface GoogleAPI {
    GoogleAPI requestSetup(String searchObj);
    GoogleAPI executeRequest();
    void flush();
    String getSpecificData(String marker);
}
