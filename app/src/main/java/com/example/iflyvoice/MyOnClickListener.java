package com.example.iflyvoice;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by zy on 2016/11/16.
 */

public class MyOnClickListener implements OnClickListener{

//	private TextView where2show= null;
	/**
	 * add 12 5
	 */
	Words wordarr[]=new Words[10];
	TextView showtextView;
	Button button;



	private String spell[] = new String[10];

	MyOnClickListener(Words w[],TextView t,Button b){
		this.wordarr = w;
		this.showtextView=t;
		this.button=b;
	}

	@Override
	public void onClick(View arg0) {

		final TextView textView = (TextView) arg0;
		final HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

		RecognizerDialog mDialog = new RecognizerDialog(
				textView.getContext(), new InitListener() {
			@Override
			public void onInit(int code) {
			}
		});
		// 设置语言为汉语 普通话
		mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
		mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
		//设置监听器
		mDialog.setListener(new RecognizerDialogListener() {

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
				if(result.length()>1) {
					result = result.substring(0, result.length() - 1);
				}
				/**
				 * 解析结果是result
				 */

//				if(word.getCharacter().equals(result)){
//					word.setFlag(true);
//					button.setText(word.getCharacter()+"T"+word.getFalg());
//				}else{
//					word.setFlag(false);
//					button.setText(word.getCharacter()+"T"+word.getFalg());
//				}
				int a=-1;
				for (int i = 0; i <10; i++) {
					if(wordarr[i].getCharacter().equals(showtextView.getText().toString())){
						a=i;
						break;
					}
				}

				Boolean falgIsRight=hanzi2pinyin(wordarr[a].getCharacter()).equals(hanzi2pinyin(result));
				if(falgIsRight){
					wordarr[a].setFlag(false);
				}else{
					wordarr[a].setFlag(true);
				}
/*only for test.
				button.setText("F:"+falgIsRight+""+result+hanzi2pinyin(wordarr[a].getCharacter())+"");
*/
			}

			@Override
			public void onError(SpeechError speechError) {
			}
		});
		mDialog.show();
	}

	public String hanzi2pinyin(String hanzi){
		if(hanzi==null){
			return null;
		}
		char hz[]=hanzi.toCharArray();
		String[] pinyinArray;
		String pinyinresult=null;
		for (char c : hz) {
			pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
			Log.i("NULL",pinyinArray[0]);
			pinyinresult+=pinyinArray[0].toString();
		}
		return  pinyinresult;
	}
}
