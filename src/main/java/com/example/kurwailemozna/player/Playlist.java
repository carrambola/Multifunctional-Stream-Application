package com.example.kurwailemozna.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Playlist {
    static List<Song> playlist = new ArrayList();
    static Integer currentSong = 0;
    public static void addToQueue(String title, String songCode){
        playlist.add(new Song(title, songCode));
    }
    public static void removeFromQueue(String title){
        playlist.forEach(song->{
           if(song.getTitle().equals(title)){
               playlist.remove(song);
           }
        });
    }
    public static void nextSong(){
        currentSong++;
    }
    public static void prevSong(){
        currentSong--;
    }
}
