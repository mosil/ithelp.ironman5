package demo.mosil.biz.in.ithelp.listview;

import java.util.ArrayList;
import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
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
	    ListView lvMoogle5 = getListView();
	    lvMoogle5.setOnItemClickListener(adapterClick);
	    setListAdapter(adapter);
	    
	}
	    
	AdapterView.OnItemClickListener adapterClick = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			String[] links = getResources().getStringArray(R.array.link);
	
			Uri uri = Uri.parse(links[position]);
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
		}
	}; 
}
