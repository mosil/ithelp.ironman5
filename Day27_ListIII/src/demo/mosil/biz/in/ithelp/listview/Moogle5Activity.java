package demo.mosil.biz.in.ithelp.listview;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class Moogle5Activity extends ListActivity {
	private final String NAME = "name";
	private final String CREATION = "creation";
	private final String LOGO = "logo";
    @Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_moogle5);
	    /* 先接出兩個來自 strings.xml 裡的字串陣列 */
	    String[] names = getResources().getStringArray(R.array.leader);
	    String[] creation = getResources().getStringArray(R.array.creation);
	    int[] logos = {R.drawable.mosil_logo_s, R.drawable.mosil_logo_k, R.drawable.mosil_logo_e};
	    //宣告一個ArrayList來存放這兩個陣列
	    ArrayList<HashMap<String, Object>> leaders = new ArrayList<HashMap<String,Object>>();
	    for(int i = 0; i < names.length; i++){
			HashMap<String, Object> leader = new HashMap<String, Object>();
			leader.put(NAME, names[i]);
			leader.put(CREATION, creation[i]);
			leader.put(LOGO, logos[i]);
			leaders.add(leader);
		}
	    
	    SimpleAdapter adapter = new SimpleAdapter(
	    		this, 
	    		leaders, 
	    		R.layout.listview_item, 
	    		new String[]{NAME, CREATION, LOGO}, 
	    		new int[]{R.id.txt_title, R.id.txt_subtitle, R.id.img_logo}
	    );
	    setListAdapter(adapter);
	    
	    /* 以下是尚未加入圖片的版本 */
	    
//	    ArrayList<HashMap<String, String>> leaders = new ArrayList<HashMap<String,String>>(); 
	    
//		for(int i = 0; i < names.length; i++){
//			HashMap<String, String> leader = new HashMap<String, String>();
//			leader.put(NAME, names[i]);
//			leader.put(CREATION, creation[i]);
//			leaders.add(leader);
//		}
		
//		setListAdapter(
//			new SimpleAdapter(
//					this, 
//					leaders,
//					R.layout.listview_item,//原本是：android.R.layout.list_content,
//					new String[]{NAME, CREATION}, 
//					new int[]{R.id.txt_title, R.id.txt_subtitle}
//					//new int[]{android.R.id.text1, android.R.id.text2}
//					));
	}
}
