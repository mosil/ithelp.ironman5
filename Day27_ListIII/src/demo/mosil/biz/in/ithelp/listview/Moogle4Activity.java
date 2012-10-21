package demo.mosil.biz.in.ithelp.listview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Moogle4Activity extends Activity {
	private RadioGroup mRdgLanguage;
	private Button mBtnSetting;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle4);
        
        setView();
    }
    
	private void setView() {
	    mRdgLanguage = (RadioGroup) findViewById(R.id.rdg_setting_language);
	    mBtnSetting = (Button) findViewById(R.id.btn_setting_ok);
	    mBtnSetting.setOnClickListener(btnClick);
	}
	
	private View.OnClickListener btnClick = 
			new View.OnClickListener() {
		public void onClick(View v) {
			/* 取得語系選擇值 */
			int lang = 0;
			switch(mRdgLanguage.getCheckedRadioButtonId()){
				case R.id.rdo_setting_tw:
					lang = 1;
					break;
				case R.id.rdo_setting_jp:
					lang = 2;
					break;
				case R.id.rdo_setting_us:
					lang = 3;
					break;
			}
			
			/* 宣告，SharedPreferences
			 * 第一個參數：key的部份請自行定義，
			 * 第二個參數：MODE_PRIVATE，設為私有，讓我們自己這個app可以使用即可
			 */
			SharedPreferences preferences = getSharedPreferences("MOSIL", MODE_PRIVATE);
			preferences.edit().putInt("LANG", lang).commit();
			
			/* 設定完成就直接離開本 */
			finish();
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle4, menu);
        return true;
    }
}
