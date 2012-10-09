package demo.mosil.biz.in.ithelp.choose;

import java.util.Locale;

import demo.mosil.biz.in.ithelp.choose.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ChocoboActivity extends Activity {

    private String mSignalString;
    private int mSignalId;
	private String mMessage;
	private Spinner mSpnChocobo;
	private RadioGroup mRdgLanguage;
	private Button mBtnBack;
	private Button mBtnShow;
	private Button mBtnSendToMoogle2;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocobo);
        setView();
        setAction();
    }

	private void setAction() {
		
        mBtnShow = (Button)findViewById(R.id.btn_show_toast);
        mBtnShow.setOnClickListener(btnClick);
        mBtnBack = (Button)findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(btnClick);
        mBtnSendToMoogle2 = (Button)findViewById(R.id.btn_send_to_moogle2);
        mBtnSendToMoogle2.setOnClickListener(btnClick);
	}
	
	private View.OnClickListener btnClick = 
		new View.OnClickListener() {
			public void onClick(View v) {
				if(v.getId() == R.id.btn_back){
					finish();
				} else if(v.getId() == R.id.btn_show_toast){
					Toast.makeText(v.getContext(), String.valueOf(mSignalId) + mSignalString + ":" + mMessage, Toast.LENGTH_LONG).show();
				} else if(v.getId() == R.id.btn_send_to_moogle2){
					Intent intent = new Intent(v.getContext(), Moogle2Activity.class);
					startActivity(intent);
					finish();
				}
			}
		};

	private void setView() {
		//從包裹取出傳來的內容
        Bundle bundle = this.getIntent().getExtras();
        //要注意，這裡得跟傳來的包裹"標籤"名稱一樣哦！
        mSignalString = bundle.getString("signal_string");
        mSignalId = bundle.getInt("signal_id");
        mMessage = bundle.getString("message");
        mSpnChocobo = (Spinner)findViewById(R.id.spn_chocobo_signal);
        mRdgLanguage = (RadioGroup) findViewById(R.id.rdg_language);
        mRdgLanguage.setOnCheckedChangeListener(rdgLanguageChange);
        setSpinnerView();
	}
	
	private RadioGroup.OnCheckedChangeListener rdgLanguageChange =
		new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				//取得系統資源
		        Resources resource = getResources();
		        //取得資源設定
		        Configuration conf = resource.getConfiguration();
		        //先給一個初始的語系設定值
		        conf.locale = Locale.TAIWAN;
		        if(checkedId == R.id.rdo_us){
		        	conf.locale = Locale.US;
		        } else if(checkedId == R.id.rdo_jp){
		        	conf.locale = Locale.JAPAN;
		        }
		        
		        //取得設定的參數內容
		        DisplayMetrics dm =resource.getDisplayMetrics();
		        //更新
		        resource.updateConfiguration(conf, dm);
		        setSpinnerView();
			}
		};
			
	private void setSpinnerView(){
		ArrayAdapter<CharSequence> adapterSignal = ArrayAdapter.createFromResource(
        		this, 
        		R.array.Signal, 
        		android.R.layout.simple_spinner_item);
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnChocobo.setAdapter(adapterSignal);
        mSpnChocobo.setSelection(mSignalId);
	}
}
