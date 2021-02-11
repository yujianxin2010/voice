package com.example.iflyvoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by asus-pc on 2016/12/5.
 */

public class train extends Activity {
    TextView title ;
    TextView introduce ;
    TextView method;
    TextView recognition;
    String qhbyz[]=new String[30];
    String qhbym[]=new String[30];
    String qhbyr[]=new String[30];
    String  qhby;
    String qhbyme;
    String qhbyre;
    String introduceshow[]=new String[]{"","","",""};
    String methodshow []= new String[]{"","","",""};
    String recognitionshow[]=new String[]{"","","",""};
    private Button button4;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
        button4 = (Button) findViewById(R.id.rtn);
        title=(TextView)findViewById(R.id.title);
        introduce =(TextView)findViewById(R.id.introduce) ;
        method=(TextView)findViewById(R.id.method);
        recognition=(TextView)findViewById(R.id.recognition);
        Bundle bundle = this.getIntent().getExtras();
        final String name = bundle.getString("name");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(train.this,MainActivity.class);
                Bundle bundle =  new Bundle();
               train.this.startActivity(intent);
            }
        });
        switch (name){
            case "5": {
                title.setText("前后鼻音训练方法介绍");
                qhby=" 有许多人发前鼻音的时候口腔开得太大,气流往上颚上顶,使得气流过早地进入" +
                        "鼻腔,把-n前面的元音发成了带鼻音的元音；而发后鼻音的时候又往" +
                        "往打不开口腔,舌头不往后拉,还是在口腔,前部发音,没有鼻腔共鸣,使得后鼻音发音不到位";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n 如何发好前、后鼻音呢?关键就是要掌握好发音的要领,前鼻音和后鼻音的发音区分主要在两点： " +
                        "   一是阻碍部位不同," +
                        "   二是开口度大小不一样.";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n"+"\n");
                qhbyre="\n  如何记忆哪些是前鼻音音节, 哪些是后鼻音音节呢? " +
                        " 前鼻音的音节比后鼻音的音节多, 本着记少不记多的原则," +
                        " 主要记后鼻音的音节. 一是记声韵配合规律. 二是记声旁代表字.\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]+"\n");

            }  break;
            case "6": {
                title.setText("平卷舌音训练方法介绍");
                qhby=" 平卷舌音";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n 平卷舌音";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n  平卷舌音\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]+"\n");

            }  break;
            case "7": {
                title.setText("鼻音边音训练方法介绍");
                qhby=" 鼻音边音";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n \n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+ "\n"+recognitionshow[0]+"\n");

            }  break;
            case "8": {
                title.setText("区分练习训练方法介绍");
                qhby="";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n .\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                 recognition.setText("\n"+recognitionshow[0]+"\n");


            }  break;
            case "9": {
                title.setText("前后鼻音训练方法介绍");
                qhby=" ";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n .";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n .\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]+"\n");


            }  break;
            case "10": {
                title.setText("平卷舌音训练方法介绍");
                qhby=" ";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n ";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n .\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]+"\n");


            }  break;
            case "11": {
                title.setText("鼻音边音训练方法介绍");
                qhby=" ";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n .";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n  .\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]+"\n");

            }  break;
            case "12": {
                title.setText("区分练习训练方法介绍");
                qhby=" ";
                for(int i =1;i<qhby.length()/14+2;i++){
                    if(i!=qhby.length()/14+1)
                        qhbyz[i]=qhby.substring((i-1)*14,14*i);
                    else
                        qhbyz[i]=qhby.substring((i-1)*14,qhby.length());
                }
                for(int j =1;j<qhby.length()/14+2;j++){
                    introduceshow[0]=introduceshow[0]+qhbyz[j]+"\n"+"  ";
                }
                introduce.setText("\n"+introduceshow[0]+"\n");
                qhbyme="\n .";
                for(int i =1;i<qhbyme.length()/14+2;i++){
                    if(i!=qhbyme.length()/14+1)
                        qhbym[i]=qhbyme.substring((i-1)*14,14*i);
                    else
                        qhbym[i]=qhbyme.substring((i-1)*14,qhbyme.length());
                }
                for(int j =1;j<qhbyme.length()/14+2;j++){
                    methodshow[0]=methodshow[0]+qhbym[j]+"\n"+"  ";
                }
                method.setText("\n"+methodshow[0]+"\n");
                qhbyre="\n  .\n";
                for(int i =1;i<qhbyre.length()/14+2;i++){
                    if(i!=qhbyre.length()/14+1)
                        qhbyr[i]=qhbyre.substring((i-1)*14,14*i);
                    else
                        qhbyr[i]=qhbyre.substring((i-1)*14,qhbyre.length());
                }
                for(int j =1;j<qhbyre.length()/14+2;j++){
                    recognitionshow[0]=recognitionshow[0]+qhbyr[j]+"\n"+"  ";
                }
                recognition.setText("\n"+recognitionshow[0]);

            }  break;


        }









    }

    }
