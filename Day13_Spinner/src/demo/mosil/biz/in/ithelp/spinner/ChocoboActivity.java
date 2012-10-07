package demo.mosil.biz.in.ithelp.spinner;

import demo.mosil.biz.in.ithelp.spinner.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ChocoboActivity extends Activity {

    private String mSignalString;
    private int mSignalId;
	private String mMessage;
	
	private String[] mSingals = new String[] {
			"壹", "貳", "參", "肆", "伍", "陸", "柒", "捌", "玖", "拾"
	};

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo);
        //從包裹取出傳來的內容
        Bundle bundle = this.getIntent().getExtras();
        //要注意，這裡得跟傳來的包裹"標籤"名稱一樣哦！
        mSignalString = bundle.getString("signal_string");
        mSignalId = bundle.getInt("signal_id");
        mMessage = bundle.getString("message");
        Spinner spnChocobo = (Spinner)findViewById(R.id.spn_chocobo_signal);
        ArrayAdapter<String> adapterSignal = new ArrayAdapter<String>(
        		this, 
        		android.R.layout.simple_spinner_item, 
        		mSingals
        );
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnChocobo.setAdapter(adapterSignal);
        spnChocobo.setSelection(mSignalId);
        //設定要呈現訊息之Button的動作
        Button btnShow = (Button)findViewById(R.id.btn_show_toast);
        btnShow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(v.getContext(), String.valueOf(mSignalId) + mSignalString + ":" + mMessage, Toast.LENGTH_LONG).show();
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
