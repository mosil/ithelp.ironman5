package demo.mosil.biz.in.ithelp.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        Button btnMain = (Button)findViewById(R.id.btn_second);
        btnMain.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v) {
    			Intent intent = new Intent(SecondActivity.this, MainActivity.class);
    			startActivity(intent);
    			Log.d("Second", "onCreate");
    		}
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Second", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Second", "onResume");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Second", "onPause");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Second", "onStop");
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Second", "onRestart");
    }
    
    @Override
    protected void onDestroy() {
    	Log.d("Second", "onDestroy");
    }
}
