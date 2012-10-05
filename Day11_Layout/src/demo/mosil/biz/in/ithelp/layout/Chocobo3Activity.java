package demo.mosil.biz.in.ithelp.layout;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class Chocobo3Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo3);
        Button btnTweet = (Button)findViewById(R.id.btn_chocobo3_tweet);
        Button btnBack = (Button)findViewById(R.id.btn_chocobo3_back);
        
        btnTweet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "chokobo", Toast.LENGTH_SHORT).show();
			}
		});
        btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_chocobo3, menu);
        return true;
    }
}
