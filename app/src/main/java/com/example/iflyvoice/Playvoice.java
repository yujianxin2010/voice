package com.example.iflyvoice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/10.
 */

public  class Playvoice  {
    public static void playManVoice(String word){
        MediaPlayer player=new MediaPlayer();


      //  String source="/storage/emulated/0/voice/man/"+word+".mp3";

        String source=Environment.getExternalStorageDirectory().getPath()+ "SD card"+ "/voicemusic/man/"+word+".mp3";
        //	String source="/storage/emulated/0/求职语言发音标准测试系统音频/求职语言发音标准测试系统音频/男声/第一部分单音节字/前后鼻音/"+word+".mp3";
        try {
            player.setDataSource(source);
        } catch (IOException e) {
            Log.i("tag=====",source);
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();

    }
    public static void playWomenVoice(String word){
        final MediaPlayer player=new MediaPlayer();
       String source=Environment.getExternalStorageDirectory().getPath()+ "SD card"+"/voicemusic/man/"+"安身立命"+".mp3";
      //  String source="/Phone/voice/women/"+word+".mp3";
        //	String source="/storage/emulated/0/求职语言发音标准测试系统音频/求职语言发音标准测试系统音频/男声/第一部分单音节字/前后鼻音/"+word+".mp3";
        try {
            player.setDataSource(source);
        } catch (IOException e) {
            Log.i("tag=====",source);
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("tag===",source);
        }
        player.start();

    }
}
