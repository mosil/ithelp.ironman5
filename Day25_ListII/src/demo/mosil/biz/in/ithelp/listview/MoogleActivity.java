package demo.mosil.biz.in.ithelp.listview;

import demo.mosil.biz.in.ithelp.listview.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MoogleActivity extends Activity {

	private String mMessage;
	private EditText mEdtMessage;
	private Spinner mSpnSignal;
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
		ArrayAdapter<CharSequence> adapterSignal = ArrayAdapter.createFromResource(
        		this, 
        		R.array.Signal, 
        		android.R.layout.simple_spinner_item);
		//選單外觀
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnSignal.setAdapter(adapterSignal);
        
        mBtnSend.setOnClickListener(btnClick);
	}
	
	private View.OnClickListener btnClick = 
		new View.OnClickListener() {
			public void onClick(View v) {
				if(v.getId() == R.id.btn_send){
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
//					startActivity(intent);
					startActivityForResult(intent, Number.MOOGLE);
				}
			}
		};
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.moogle, menu);
	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_moogle:
				Intent intent = new Intent(this, Moogle3Activity.class);
//				startActivity(intent);
				//用startActivityForResult來取代之
				startActivityForResult(intent, Number.MOOGLE);
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //從回傳碼來決定要對誰做動作
        switch(resultCode){
        	case Number.Chocobo:
        		mSpnSignal.setSelection(data.getIntExtra("signal_id", 0));
        		break;
        	case Number.MOOGLE2:
        		Toast.makeText(this
        				, data.getStringExtra("message")
        				, Toast.LENGTH_SHORT).show();
        		break;
        	case Number.MOOGLE3:
        		Toast.makeText(this, "看過清單了", Toast.LENGTH_SHORT).show();
        		break;
        }
    }
}
