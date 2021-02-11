package com.example.iflyvoice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by asus-pc on 2016/11/3.
 */
public class four extends Activity {


    String [] qzspell={"ang","an","beng","ben","jing3","jin3","weng","wen","shang","shan"};
    String qzstr[] =new String[]{"昂","安","蹦","笨","景","紧","翁","温","赏","陕",};
    String pzspell[]=new String[]{"zao","zhao","cou","chou","ci","chi","zan","zhan","sen","shen"};
    String pzstr[] =new String[]{"早","找","凑","臭","词","持","赞","站","森","深",};
    String bzspell[]=new String[]{"la","na","lai","nai","li","ni","lu","nu","lv","nv"};
    String bzstr[]=new String[]{"拉","拿","赖","耐","里","你","路","怒","吕","女"};
    String qfzspell[] = new String[]{"jing2","jin","jing","jin2","shu","shu2","su","niu","liu","liu2"};
    String qfzstr[]=new String[]{"精","金","晶","筋","书","叔","苏","牛","刘","流"};/*delete "酥"*/
    String qcspell[]=new String[]{"xingfen","zhencheng","shengming","wenzhong","zhengming","angyang","anshenliming","ningjing","zhongzhichengcheng","cunxin"};
    String qcstr[]=new String[]{"兴奋","真诚","生命","稳重","证明","昂扬","安身立命","宁静","众志成城","存心"};
    String pcspell[]=new String[]{"zhashi","zisi","zhaoze","shaozi","chouzi","shurong","chun","zhi","chousi","cizhuan"};
    String pcstr[]=new String[]{"扎实","自私","沼泽","勺子","筹资","殊荣","唇枪舌战","职场","抽丝剥茧","瓷砖"};
    String bcspell[]=new String[]{"liunian","niunie","liul","lengn","nengl","niun","liaon","nianl","liliang","liun"};
    String bcstr[]=new String[]{"留念","扭捏","浏览","冷暖","能力","牛奶","辽宁","年龄","力量","刘奶奶"};
    String qfcspell[]=new String[]{"shenqing","senlin","sengren","ruabjian","yuanfen","zhongnanlanzilanqiu","shenghuo","sishisishishishi"};
    String qfcstr[] = new String[]{"申请","森林","僧人","软件","缘分","中南男子篮球 ","生活","四是四,十是十",};

    int num[] = new int[10];
    private TextView textView11 ;       //测试界面显示字词
    private int count =0;
    private TextView textView12;       //测试界面标题
    private Button imageButton;     //录音按钮
    private boolean flag1=false;
    private boolean flag2 =true;
    private boolean flag3  = false;
    private ProgressBar progressBar ;
    //private ArrayList<Words> word= new ArrayList<Words>;
    private Words words[]=new Words[10];
    private  Button nextButton;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_test);
        textView11 = (TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);
        imageButton=(Button)findViewById(R.id.imageButton);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        nextButton=(Button)findViewById(R.id.button13);
        progressBar.setProgress(1);
//	    /**
//	     * dobyzy on 2016/11/17
//	     */
        //   随机在0--9生成5个数
        int i =0;
        while (i < 5) {
            boolean flag = true;
            int k =(int)(10*Math.random());
            for (int j = 0; j < num.length; j++) {
                if (k == num[j])
                    flag = false;
            }
            if (flag) {
                num[i] = k;
                i++;
            }
        }
//        //接收信息以判断是用户选择进行什么测试,并显示标题
        Bundle bundle = this.getIntent().getExtras();
       final String name = bundle.getString("name");

        switch(name) {
            case "5":
            {
                textView12.setText("前后鼻音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                for(int k=0;k<10;k++){
                    Words word = new Words(qzspell[k],qzstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "6":
            {
                textView12.setText("平卷舌音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                for(int k=0;k<10;k++){
                    Words word = new Words(pzspell[k],pzstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "7":
            { textView12.setText("鼻音边音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                for(int k=0;k<10;k++){
                    Words word = new Words(bzspell[k],bzstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "8":
            {textView12.setText("区分练习测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                progressBar.setMax(10);
                flag1=true;
                for(int k=0;k<10;k++){
                    Words word = new Words(qfzspell[k],qfzstr[k]);
                    words[k]=word;
                }
                for(int j =0;j<num.length;j++){
                    num[j]=j;
                }

            }
            break;

            case "9":
            { textView12.setText("前后鼻音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                for(int k=0;k<10;k++){
                    Words word = new Words(qcspell[k],qcstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "10":
            {textView12.setText("平卷舌音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                for(int k=0;k<10;k++){
                    Words word = new Words(pcspell[k],pcstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "11":
            {textView12.setText("鼻音边音测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,86));
                for(int k=0;k<10;k++){
                    Words word = new Words(bcspell[k],bcstr[k]);
                    words[k]=word;
                }
            }
            break;

            case "12":
            {textView12.setText("区分练习测试");
                textView12.setGravity(Gravity.CENTER);
                textView11.setTextColor(Color.rgb(273,79,88));
                progressBar.setMax(8);
                flag1=true;
                flag3=true;
                for(int k=0;k<8;k++){
                    Words word = new Words(qfcspell[k],qfcstr[k]);
                    words[k]=word;
                }

                for(int j =0;j<num.length;j++){
                    num[j]=j;
                }
            }
            break;
        }



//  当用户进入测试界面后，根据前面生成的存放随机数的数组，立即显示第一个字或词，
        textView11.setText(words[num[0]].getCharacter());
        textView11.setGravity(Gravity.CENTER);


      imageButton.setOnClickListener(new MyOnClickListener(words,textView11,imageButton));


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag1) {
                    if(flag3) {
                        if (count == 7) {
                            flag2 = false;
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("words", (Serializable) words);
                            bundle.putString("name", name);
                            intent.putExtras(bundle);
                            intent.setClass(four.this, result.class);
                            four.this.startActivity(intent);
                        }
                    }else if (count == 9) {
                            flag2 = false;
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("words", (Serializable) words);
                            bundle.putString("name", name);
                            intent.putExtras(bundle);
                            intent.setClass(four.this, result.class);
                            four.this.startActivity(intent);
                        }

                }else{
                    if (count == 4) {
                        flag2 =false;
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("words", (Serializable) words);
                        bundle.putString("name",name);
                        intent.putExtras(bundle);
                        intent.setClass(four.this, result.class);
                        four.this.startActivity(intent);
                    }

                }
                if(flag2) {
                    count++;
                    textView11.setText(words[num[count]].getCharacter());
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(count+1);
                }

            }
        });

    }
}
