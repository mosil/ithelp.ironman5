package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Moogle2Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle2);
        Button btnRequestToMoogle1 = (Button)findViewById(R.id.btn_request);
        btnRequestToMoogle1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: 被點擊後要執行的動作 */
				Intent intent = new Intent(Moogle2Activity.this, Moogle1Activity.class);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle2, menu);
        return true;
    }
}
