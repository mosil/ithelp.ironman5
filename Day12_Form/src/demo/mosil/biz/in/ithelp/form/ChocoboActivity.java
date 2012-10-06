package demo.mosil.biz.in.ithelp.form;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChocoboActivity extends Activity {

    private String mSignal;
	private String mMessage;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo);
        //從包裹取出傳來的內容
        Bundle bundle = this.getIntent().getExtras();
        //要注意，這裡得跟傳來的包裹"標籤"名稱一樣哦！
        mSignal = bundle.getString("signal");	
        mMessage = bundle.getString("message");
        //設定要呈現訊息之Button的動作
        Button btnShow = (Button)findViewById(R.id.btn_show_toast);
        btnShow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(v.getContext(), mSignal + ":" + mMessage, Toast.LENGTH_LONG).show();
			}
		});
        //設定要返回的按鈕動作
        Button btnBack  =(Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_chocobo, menu);
        return true;
    }
}
