package com.example.kurwailemozna.player.UIfunctionalities;

import com.example.kurwailemozna.player.Player;
import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.Song;
import com.example.kurwailemozna.player.google.GoogleSearch;

import java.util.Map;

public class AddToQueueButton extends Button{
    GoogleSearch googleSearch;
    public void onClick(Song song) {
        Playlist.addToQueue(song.getTitle(), song.getYtCode(), song.getDuration());
    }
    public void playFirst(Player player, Song song){
        if(Playlist.getQueue().size() == 0){
            player.playSong(song);
        }
    }
}
