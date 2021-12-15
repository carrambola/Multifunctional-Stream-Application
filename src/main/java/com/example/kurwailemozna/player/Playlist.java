package com.example.kurwailemozna.player;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class Playlist {
    static List<Song> playlist = new ArrayList<>();
    public static Integer currentSong = 0;
    public static void addToQueue(String title, String songCode, Integer duration){
        playlist.add(new Song(title, songCode, duration));
    }
    public static void removeFromQueue(String title){
        playlist.forEach(song->{
            if(song.getTitle().equals(title)){
                playlist.remove(song);
            }
        });
    }
    public static ObservableList<String> songToTitleConversion(){
        ObservableList<String> titles = FXCollections.observableArrayList();
        playlist.forEach(song -> {
            titles.add(song.getTitle());
        });
        return titles;
    }
    public static List<Song> getQueue(){
        return playlist;
    }
    public static void clearQueue(){
        playlist = new ArrayList<>();
    }
    public static void nextSong(){
        currentSong++;
    }
}
