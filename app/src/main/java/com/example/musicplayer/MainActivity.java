package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop, song1, song2, song3;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btn_play);
        pause = (Button) findViewById(R.id.btn_pause);
        stop = (Button) findViewById(R.id.btn_stop);
        song1 = (Button) findViewById(R.id.song1);
        song2 = (Button) findViewById(R.id.song2);
        song3 = (Button) findViewById(R.id.song3);

        song1.setOnClickListener(this);
        song2.setOnClickListener(this);
        song3.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void selectSong(View view)
    {
        switch(view.getId())
        {
            case R.id.song1:
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.jeevamshamayi);
                mediaPlayer.start();
                song1.setPressed(true);
                song2.setPressed(false);
                song3.setPressed(false);
                break;

            case R.id.song2:
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.priyanumathram);
                mediaPlayer.start();
                song2.setPressed(true);
                song1.setPressed(false);
                song1.setPressed(false);
                break;

            case R.id.song3:
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sunrahahai);
                mediaPlayer.start();
                song3.setPressed(true);
                song1.setPressed(false);
                song2.setPressed(false);
                break;
        }
    }

    public void onClick(View view)
    {
        selectSong(view);
        switch (view.getId())
        {
            case R.id.btn_play:
                if(mediaPlayer==null)
                {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sunrahahai);
                mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                 mediaPlayer.seekTo(pauseCurrentPosition);
                 mediaPlayer.start();
                }
                break;

            case R.id.btn_pause:
                if(mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                    pauseCurrentPosition = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.btn_stop:
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }
}
