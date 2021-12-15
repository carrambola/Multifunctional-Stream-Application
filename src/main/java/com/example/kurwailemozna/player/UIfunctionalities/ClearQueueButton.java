package com.example.kurwailemozna.player.UIfunctionalities;

import com.example.kurwailemozna.player.Playlist;
import com.example.kurwailemozna.player.Song;

import java.util.ArrayList;

public class ClearQueueButton extends Button{

    public void onClick(){
        Playlist.clearQueue();
    }
}
