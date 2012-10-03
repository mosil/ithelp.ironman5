package demo.mosil.biz.in.ithelp.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main", "onCreate");
        
        Button btnMain = (Button)findViewById(R.id.btn_main);
        btnMain.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v) {
    			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
    			startActivity(intent);
    		}
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "onResume");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "onPause");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main", "onStop");
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Main", "onRestart");
    }
    
    @Override
    protected void onDestroy() {
    	Log.d("Main", "onDestroy");
    }
}
