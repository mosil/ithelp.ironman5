package demo.mosil.biz.in.ithelp.choose;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class Moogle3Activity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle3);
        
		setListAdapter(
			new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.leader)
			)
		);
    }
}
