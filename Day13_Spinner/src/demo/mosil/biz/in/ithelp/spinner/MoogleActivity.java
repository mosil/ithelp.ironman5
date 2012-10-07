package demo.mosil.biz.in.ithelp.spinner;

import demo.mosil.biz.in.ithelp.spinner.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MoogleActivity extends Activity {

	private String mMessage;
	private EditText mEdtMessage;
	private Spinner mSpnSignal;
	
	private String[] mSingals = new String[] {
			"壹", "貳", "參", "肆", "伍", "陸", "柒", "捌", "玖", "拾"
	};
	private Button mBtnSend;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle);
        setView();
        setAction();
    }

	private void setView() {
		//下拉選單
        mSpnSignal = (Spinner)findViewById(R.id.spn_signal);
        //輸入框
        mEdtMessage = (EditText)findViewById(R.id.edt_message);
        //按鈕
        mBtnSend = (Button)findViewById(R.id.btn_send);
	}

	private void setAction() {
		ArrayAdapter<String> adapterSignal = new ArrayAdapter<String>(
        		this, //Context
        		android.R.layout.simple_spinner_item, //選單格式
        		mSingals	//選單內容
        );
		//選單外觀
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnSignal.setAdapter(adapterSignal);
        
        mBtnSend.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//取得 EditText 的內容
		        mMessage = mEdtMessage.getText().toString();
		        //準備切換的意圖
				Intent intent = new Intent(v.getContext(), ChocoboActivity.class);
				//準備切換時要傳遞的包裹
				Bundle bundle = new Bundle();
				//在包裹內放入一個key為signal_string的選單選擇文字
				bundle.putString("signal_string", mSpnSignal.getSelectedItem().toString());
				//在包裹內放入一個key為signal_id的選單選擇值
				bundle.putInt("signal_id", mSpnSignal.getSelectedItemPosition());
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
