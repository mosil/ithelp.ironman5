package demo.mosil.biz.in.ithelp.listview;

import java.util.ArrayList;
import java.util.HashMap;

import demo.mosil.biz.in.ithelp.listview.R;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class Moogle3Activity extends ListActivity {
	private Button mBtnBack;
	private final String NAME = "name";
	private final String CREATION = "creation";
    @Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_moogle3);
	    /* 先接出兩個來自 strings.xml 裡的字串陣列 */
	    String[] names = getResources().getStringArray(R.array.leader);
	    String[] creation = getResources().getStringArray(R.array.creation);
	    //宣告一個ArrayList來存放這兩個陣列
	    ArrayList<HashMap<String, String>> leaders = new ArrayList<HashMap<String,String>>(); 
	    
		for(int i = 0; i < names.length; i++){
			HashMap<String, String> leader = new HashMap<String, String>();
			leader.put(NAME, names[i]);
			leader.put(CREATION, creation[i]);
			leaders.add(leader);
		}
		setListAdapter(
			new SimpleAdapter(
					this, 
					leaders,
					android.R.layout.simple_list_item_2,
					new String[]{NAME, CREATION}, 
					new int[]{android.R.id.text1, android.R.id.text2}));
		
		mBtnBack = (Button)findViewById(R.id.btn_moogle3_back);
		mBtnBack.setOnClickListener(btnClick);
	}
    private View.OnClickListener btnClick = 
    		new View.OnClickListener() {
    	public void onClick(View v) {
	    	setResult(Number.MOOGLE3);
	    	finish();
    	}
    };
}
