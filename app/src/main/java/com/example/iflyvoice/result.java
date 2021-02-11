package com.example.iflyvoice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.resource.Resource;

import java.lang.reflect.Field;


public class result extends Activity {

	ListView listView;
  private  Button result;
	MediaPlayer player=new MediaPlayer();

	private Boolean flag=false;
	private int wordlength=10;
	private  int tag =0;
	int  [] bbuttons={R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,R.id.manvoice,};
	int [] gbuttons ={R.id.girlvoice,R.id.girlvoice,R.id.girlvoice,R.id.girlvoice,R.id.manvoice,R.id.manvoice,R.id.girlvoice,R.id.girlvoice,R.id.girlvoice,R.id.girlvoice,};
	String [] qzspell={"ang","an","beng","ben","jing3","jin3","weng","wen","shang","shan"};

	public  void playvoice (String word){

		int id =getresourceId(word);
		final MediaPlayer player = MediaPlayer.create(this,id);
		player.start();
	}
	public static int getresourceId(String name){
		Field field;
			try {
			field = R.raw.class.getField(name);
			return Integer.parseInt(field.get(null).toString());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testresult);
		listView = (ListView) this.findViewById(R.id.listView);


		result = (Button)findViewById(R.id.result);
		Intent intent = getIntent();
		Bundle bundle = this.getIntent().getExtras();
		final String name = bundle.getString("name");
		result.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("name",name);
				intent.putExtras(bundle);
				intent.setClass(result.this, train.class);
				result.this.startActivity(intent);
			}
		});

		if(name .equals("12")){
			wordlength =8;
		}
		/*原来的
		Words word[] = (Words[]) this.getIntent().getSerializableExtra("words");
		*/
		Object object[]=(Object[]) this.getIntent().getSerializableExtra("words");
		Words word[]=new Words[object.length];
		for(int i=0;i<object.length;i++){
			word[i]= (Words) object[i];
		}
		/* the below is done by zy */
		int length=0;

		for(int i=0;i<wordlength;i++){

				if (word[i].getFalg()) {
					length++;
				}

		}
		String spell[] =new String[length] ;
		String character[]=new String[length];

		for(int j=0,i=0; j<wordlength; j++){

			if(word[j].getFalg()){
				spell[i]=word[j].getSpell();
				character[i] =word[j].getCharacter();
				i++;
			}
		}


		ListViewAdapter listViewAdapter = new ListViewAdapter(spell, character, bbuttons, gbuttons,this);
		listView.setAdapter(listViewAdapter);



	}
	public class ListViewAdapter extends BaseAdapter {
		String words[] =new String[]{"昂","安","蹦","笨","景","紧","翁","温","赏","陕",
				"早","找","凑","臭","词","持","赞","站","森","深","拉","拿","赖","耐","里","你","路","怒","吕","女",
				"精","金","晶","筋","书","叔","苏","牛","刘","流","兴奋","真诚",
				"生命","稳重","证明","昂扬","安身立命","宁静","众志成城","存心",
				"扎实","自私","沼泽","勺子","筹资","殊荣","唇枪舌战","职场","抽丝剥茧","瓷砖",
				"留念","扭捏","浏览","冷暖","能力","牛奶","辽宁","年龄","力量","刘奶奶",
				"申请","森林","僧人","软件","缘分","中南男子篮球 ","生活","四是四,十是十"
		};
		String pinyin[]=new String[]{"áng","ān","bèng","bèn","jǐng","jǐn","wēng","wēn","shǎng","shǎn",
				"zǎo","zhǎo","còu","chòu","cí","chí","zàn","zhàn","sēn","shēn",
				"lā","ná","lài","nài","lǐ","nǐ","lù","nù","lǚ","nǚ",
				"jīng",  "jīn",  "jīng",  "jīn"  ,"shū",  "shū" , "sū",    "niú",  "liú",  "liú",
				"xīng fèn","zhēn chéng","shēng mìng","wěn zhòng","zhèng míng","áng yáng","ān shēn lì mìng ","níng jìng","zhòng zhì chéng chéng","cún xīn ",
				"zhā shí","zì sī","zhǎo zé ","sháo zǐ","chóu zī","shū róng","chún qiāng shé zhàn","zhí chǎng","chōu sī bāo jiǎn","cí zhuān",
				"liú niàn","niǔ niē","liú lǎn","lěng nuǎn","néng lì","niú nǎi","liáo níng","nián líng","lì liàng","liú nǎi nɑi",
				"shēn qǐng ", "sēn lín"," sēng rén","ruǎn jiàn","yuán fèn","zhōng nán nán zǐ lán qiú","shēng huó","sì shì sì ，shí shì shí"};

		View[] itemViews;
		private  String []itemtitle;
		private  String []itemtext ;
       private  LayoutInflater mInflater;

		public ListViewAdapter(String [] itemTitles, String [] itemTexts,
		                       int [] manvoice,int []girlvoice,Context context){

			itemViews = new View[itemTitles.length];
			itemtitle=itemTitles;
			itemtext = itemTexts;
            this.mInflater = LayoutInflater.from(context);
		}

		public int getCount() {
			return itemViews.length;
		}



		public View getItem(int position) {
			return itemViews[position];
		}

		public long getItemId(int position) {
			return position;
		}

		private View makeItemView(String strTitle, String strText, int manvoice,int girlvoice) {
			LayoutInflater inflater = (LayoutInflater)result.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			// 使用View的对象itemView与R.layout.item关联
			View itemView = inflater.inflate(R.layout.listitem, null);

			// 通过findViewById()方法实例R.layout.item内各组件
			TextView title = (TextView)itemView.findViewById(R.id.itemTitle);
			title.setText(strTitle);
			TextView text = (TextView)itemView.findViewById(R.id.itemText);
			text.setText(strText);
			Button button = (Button)findViewById(R.id.manvoice);
			Button button1  = (Button)findViewById(R.id.girlvoice);
			return itemView;
		}

		public View getView(final  int position, View convertView, ViewGroup parent) {
			final ViewHolder holder;
			//观察convertView随ListView滚动情况
			Log.v("MyListViewBase", "getView " + position + " " + convertView);
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.listitem, null);
				holder = new ViewHolder();
                    /*得到各个控件的对象*/
				holder.title = (TextView) convertView.findViewById(R.id.itemTitle);
				holder.text = (TextView) convertView.findViewById(R.id.itemText);
				holder.bt = (Button) convertView.findViewById(R.id.manvoice);
				holder.bt2=(Button)convertView.findViewById(R.id.girlvoice);
				convertView.setTag(holder);//绑定ViewHolder对象
			}
			else{
				holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象
			}
            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/

			int i=0;
			for(;i<words.length;i++){
				if(itemtext[position].equals(words[i]))
					break;
			};
			holder.title.setText(pinyin[i]);
			holder.text.setText(itemtext[position]);



            /*为Button添加点击事件*/
			holder.bt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					playvoice(itemtitle[position]);
				}

			});

			holder.bt2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					playvoice(itemtitle[position]+"v");
				}
			});
			return convertView;

		}
	}

	public final class ViewHolder{
		public TextView title;
		public TextView text;
		public Button   bt;
		private  Button bt2;
	}


}



