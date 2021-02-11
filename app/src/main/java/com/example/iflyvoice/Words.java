package com.example.iflyvoice;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by YIDN on 2016/11/19.
 */
public class Words implements Serializable{
	private String spell;
	private String character;
	private Boolean falg;


	public Words(String spe,String charS){
		this.spell=spe;
		this.character=charS;
		falg=false;
		/**
		 * flag表示显示与否
		 *
		 * true则在测试结果界面
		 * flase不显示
		 */

	}
	public  String getSpell(){
		return this.spell;
	}

	public void setSpell(String s){
		this.spell =s;
	}

	public void setFlag(Boolean bool){
		this.falg= bool;
	}
	public Boolean getFalg(){
		return this.falg;
	}

	public  void setCharacter(String charc){
		this.character = charc;
	}
	public String getCharacter(){
		return this.character;
	}

	public void playManVoice(){
		MediaPlayer player=new MediaPlayer();
		String word=this.getCharacter();
		String source="/storage/emulated/0/voice/man/"+word+".mp3";
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
	public void playWomanVoice(){
		MediaPlayer player=new MediaPlayer();
		String word=this.getCharacter();
		String source="/storage/emulated/0/voice/women/"+word+".mp3";
		//	String source="/storage/emulated/0/求职语言发音标准测试系统音频/求职语言发音标准测试系统音频/女声/第一部分单音节字/前后鼻音/"+word+".mp3";
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

}
