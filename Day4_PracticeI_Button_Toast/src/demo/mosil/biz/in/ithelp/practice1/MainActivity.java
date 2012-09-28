package demo.mosil.biz.in.ithelp.practice1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int mCount;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* TODO: 招式建構區 */
        //點擊的次數
        mCount = 0;
        Button btnAttack = (Button)findViewById(R.id.btnAttack);
        btnAttack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: 被點擊後要執行的動作 */
				//點擊一次就+1
				mCount++;
				//要呈現的訊息字串
				String msg = "您連續攻擊了" + mCount + "次";
				Toast.makeText(v.getContext(), msg, Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
