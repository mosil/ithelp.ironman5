package demo.mosil.biz.in.ithelp.form;

import demo.mosil.biz.in.ithelp.form.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoogleActivity extends Activity {

    private String mSignal;
	private String mMessage;
	private EditText mEdtSignal;
	private EditText mEdtMessage;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle);
        //宣告從介面上元件類型為EditText的二個元素
        mEdtSignal = (EditText)findViewById(R.id.edt_signal); 
        mEdtMessage = (EditText)findViewById(R.id.edt_message);
        //按鈕
        Button btnSend = (Button)findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//取得兩個 EditText 的內容
				mSignal = mEdtSignal.getText().toString();
		        mMessage = mEdtMessage.getText().toString();
		        //準備切換的意圖
				Intent intent = new Intent(v.getContext(), ChocoboActivity.class);
				//準備切換時要傳遞的包裹
				Bundle bundle = new Bundle();
				bundle.putString("signal", mSignal);
				bundle.putString("message", mMessage);
				intent.putExtras(bundle);
				//切換
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle, menu);
        return true;
    }
}
