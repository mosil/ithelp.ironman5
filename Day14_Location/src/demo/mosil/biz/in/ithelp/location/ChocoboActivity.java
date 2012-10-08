package demo.mosil.biz.in.ithelp.location;

import java.util.Locale;

import demo.mosil.biz.in.ithelp.location.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ChocoboActivity extends Activity {

    private String mSignalString;
    private int mSignalId;
	private String mMessage;
	private Spinner mSpnChocobo;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo);
        //取得系統資源
        Resources resource = getResources();
        //取得資源設定
        Configuration conf = resource.getConfiguration();
        //切換這個Activity的語系
        conf.locale = Locale.TAIWAN;
        //取得設定的參數內容
        DisplayMetrics dm =resource.getDisplayMetrics();
        //更新
        resource.updateConfiguration(conf, dm);
        setView();
        setAction();
    }

	private void setAction() {
		ArrayAdapter<CharSequence> adapterSignal = ArrayAdapter.createFromResource(
        		this, 
        		R.array.Signal, 
        		android.R.layout.simple_spinner_item);
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnChocobo.setAdapter(adapterSignal);
        mSpnChocobo.setSelection(mSignalId);
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

	private void setView() {
		//從包裹取出傳來的內容
        Bundle bundle = this.getIntent().getExtras();
        //要注意，這裡得跟傳來的包裹"標籤"名稱一樣哦！
        mSignalString = bundle.getString("signal_string");
        mSignalId = bundle.getInt("signal_id");
        mMessage = bundle.getString("message");
        mSpnChocobo = (Spinner)findViewById(R.id.spn_chocobo_signal);
	}
}
