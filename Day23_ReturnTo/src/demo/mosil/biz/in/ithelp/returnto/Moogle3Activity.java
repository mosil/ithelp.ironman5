package demo.mosil.biz.in.ithelp.returnto;

import demo.mosil.biz.in.ithelp.returnto.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Moogle3Activity extends ListActivity {
	private Button mBtnBack;
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
