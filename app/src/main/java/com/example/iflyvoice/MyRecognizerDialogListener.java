package com.example.iflyvoice;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * Created by zy on 2016/11/14.
 */
public class MyRecognizerDialogListener implements RecognizerDialogListener {

	private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();
//	private ImageView imageView;
	private TextView textView = null;

	public MyRecognizerDialogListener(/*ImageView imageView,*/TextView textView){
//		this.imageView =imageView;
		this.textView = textView;
	}


	@Override
	public void onResult(RecognizerResult arg0, boolean arg1) {
		String text = JsonParser.parseIatResult(arg0.getResultString());
		System.out.println("text" + text);
		String sn = null;
		try {
			JSONObject resultJson = new JSONObject(arg0.getResultString());
			sn = resultJson.optString("sn");
			System.out.println("sn" + sn);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		mIatResults.put(sn, text);

		StringBuffer resultBuffer = new StringBuffer();
		for (String key : mIatResults.keySet()) {
			resultBuffer.append(mIatResults.get(key));
		}
		String result =  resultBuffer.toString();
		result = result.substring(0,result.length()-1);
		textView.setText(result);
		/**
		 * 解析结果是result
		 */
//		if(textView.getText().equals(result)){
//			//如果读音正确。。。
//		}
	}

	@Override
	public void onError(SpeechError arg0) {

	}
}
