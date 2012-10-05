package demo.mosil.biz.in.ithelp.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Chocobo1Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo1);
        
        Button btnGoChocobo2 = (Button)findViewById(R.id.btn_layout_linear);
        Button btnGoChocobo3 = (Button)findViewById(R.id.btn_layout_linear2);
        
        btnGoChocobo2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goActivity(1);
			}
		});
        btnGoChocobo3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goActivity(2);
			}
		});
    }
    
    private void goActivity(int which){
    	Intent intent;
		
    	switch(which){
    		case 1:
    			intent = new Intent(this, Chocobo2Activity.class);
    			break;
    		case 2:
    			intent = new Intent(this, Chocobo3Activity.class);
    			break;
    		default:
    			intent = null;
    			break;
    	}
    	
    	if(intent != null){
    		startActivity(intent);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
