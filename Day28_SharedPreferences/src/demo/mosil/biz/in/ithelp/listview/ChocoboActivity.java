package demo.mosil.biz.in.ithelp.listview;

import java.util.Locale;

import demo.mosil.biz.in.ithelp.listview.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
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
			Bundle bundle = new Bundle();
			bundle.putInt("signal_id", mSpnChocobo.getSelectedItemPosition());
			if(v.getId() == R.id.btn_back){
				Intent intent = new Intent();
				intent.putExtras(bundle);
				setResult(Number.Chocobo, intent);
				finish();
			} else if(v.getId() == R.id.btn_show_toast){
				Toast.makeText(v.getContext(), String.valueOf(mSignalId) + mSignalString + ":" + mMessage, Toast.LENGTH_LONG).show();
			} else if(v.getId() == R.id.btn_send_to_moogle2){
				Intent intent = new Intent(v.getContext(), Moogle2Activity.class);
				intent.putExtras(bundle);
				startActivityForResult(intent, Number.Chocobo);
//					startActivity(intent);
			}
		}
	};
		
	@Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //從回傳碼來決定要對誰做動作
        switch(resultCode){
        	case Number.MOOGLE2:
        		Toast.makeText(this
        				, data.getStringExtra("message")
        				, Toast.LENGTH_LONG).show();
        		break;
        }
    }

	private void setView() {
		mPreferences = getSharedPreferences("MOSIL", MODE_PRIVATE);
		int lang = mPreferences.getInt("LANG", 0);
		//取得系統資源
        Resources resource = getResources();
        //取得資源設定
        Configuration conf = resource.getConfiguration();
        switch(lang){
	        case 1:
	        	conf.locale = Locale.TAIWAN;
	        	break;
	        case 2:
	        	conf.locale = Locale.JAPAN;
	        	break;
	        case 0:
	        case 3:
        	default:
        		conf.locale = Locale.US;
        		break;
        }
        DisplayMetrics dm =resource.getDisplayMetrics();
        //更新
        resource.updateConfiguration(conf, dm);
		
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
	private SharedPreferences mPreferences;
			
	private void setSpinnerView(){
		ArrayAdapter<CharSequence> adapterSignal = ArrayAdapter.createFromResource(
        		this, 
        		R.array.Signal, 
        		android.R.layout.simple_spinner_item);
        adapterSignal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnChocobo.setAdapter(adapterSignal);
        mSpnChocobo.setSelection(mSignalId);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//設定一個選單元素，這邊的參數依序如下說明  
	    //0: 屬於哪個選單群組  
	    //Menu.FIRST: 選單元素的id  
	    //0: 第幾個順位  
	    //getResources().getString(R.string.menu_list: 選單名稱  
	    menu.add(0, Menu.FIRST, 0, getResources().getString(R.string.menu_list))
	    		.setIcon(android.R.drawable.ic_menu_agenda);
	    
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
			//因為是id，所以要記得這時候的id，是被設定為Menu.FIRST哦！  
			case Menu.FIRST:
				Intent intent = new Intent(this, Moogle3Activity.class);
				startActivity(intent);
				finish();
				break;
		}
	    //這一行一定不能少
		return super.onOptionsItemSelected(item);
	}
}
