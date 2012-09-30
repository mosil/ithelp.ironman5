package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Moogle1Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle1);
        Button btnCallMoogle2 = (Button)findViewById(R.id.btn_call_moogle2);
        btnCallMoogle2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: 被點擊後要執行的動作 */
				Intent intent = new Intent(Moogle1Activity.this, Moogle2Activity.class);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle1, menu);
        return true;
    }
}
