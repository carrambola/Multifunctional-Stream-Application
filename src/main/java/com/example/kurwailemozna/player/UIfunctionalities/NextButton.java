package com.example.kurwailemozna.player.UIfunctionalities;

import com.example.kurwailemozna.player.Playlist;

public class NextButton extends Button{

    public void onClick(){
        if(Playlist.getQueue().size()>1){
            Playlist.nextSong();
        }

    }
}
