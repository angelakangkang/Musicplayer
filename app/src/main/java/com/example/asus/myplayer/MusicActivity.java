package com.example.asus.myplayer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;


public class MusicActivity extends Activity implements View.OnClickListener{
    private Button src;
    private Button sd;
    private Button pause;
    private Button stop;
    private MediaPlayer mediaPlayer= new MediaPlayer();
    private boolean isRelease = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        src=(Button)findViewById(R.id.src);
        sd=(Button)findViewById(R.id.sd);
        pause=(Button)findViewById(R.id.pause);
        stop=(Button)findViewById(R.id.stop);
        src.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);
        sd.setOnClickListener(this);


//        stop.setOnClickListener(new ButtonListener());
//        pause.setOnClickListener(new ButtonListener());
//        sd.setOnClickListener(new ButtonListener());


//        src.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    mediaPlayer.setDataSource("/raw/wawawamp3");
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (IllegalStateException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        mp.release();
//                    }
//                });
//
//            }
//        });
//        pause.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if(mediaPlayer != null){
//                    mediaPlayer.pause();
//                }
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if(mediaPlayer != null){
//                    mediaPlayer.stop();
//                }
//            }
//        });
    }

//    @Override
//    protected void onDestroy() {
//        if(mediaPlayer != null)
//            mediaPlayer.release();
//        super.onDestroy();
//    }




//

    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.src:
//                    mediaPlayer = MediaPlayer.create(this, R.raw.wawawamp3);
//                    mediaPlayer.setOnCompletionListener(this);
//                    if (mediaPlayer != null)
//                        mediaPlayer.stop();
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
                    if(isRelease){
                        mediaPlayer = MediaPlayer.create(this,R.raw.wawawamp3);
                        isRelease = false;
                    }
                    mediaPlayer.start();   //开始播放
                    src.setEnabled(false);
                    pause.setEnabled(true);
                    stop.setEnabled(true);
                    break;

                case R.id.sd:
//
////                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
////                    mediaPlayer.setDataSource("http://music.163.com/#/song?id=405485737");
////                    Uri uri = Uri
////                            .parse("http://music.163.com/#/song?id=405485737");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource("/SD卡/Music/Tryeverything.mp3");
                    mediaPlayer.prepare();
                    mediaPlayer.start();

//                    File sdFile = Environment.getExternalStorageDirectory();
//                    this.mediaPlayer = new MediaPlayer();
//                    this.mediaPlayer.setDataSource(sdFile.getAbsoluteFile() + File.separator + "I AM You.mp3");
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();

//                    String url = "http://music.163.com/#/song?id=405485737"; // your URL here
//                    mediaPlayer = new MediaPlayer();
//                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    mediaPlayer.setDataSource(url);
//                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
//                    mediaPlayer.start();

                    break;
                case R.id.stop:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    break;
                case R.id.pause:
                    if (mediaPlayer != null) {
                        mediaPlayer.pause();
                    }
            }
        } catch (Exception e) {
            Toast.makeText(this, "异常" + e.toString(), Toast.LENGTH_LONG).show();
        }
       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
