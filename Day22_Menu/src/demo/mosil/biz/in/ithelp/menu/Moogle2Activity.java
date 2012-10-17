package demo.mosil.biz.in.ithelp.menu;

import demo.mosil.biz.in.ithelp.menu.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class Moogle2Activity extends Activity {

    private Button mBtnChoose;
	private Button mBtnBack;
	private CheckBox mChkSephiroth;
	private CheckBox mChkKefka;
	private CheckBox mChkExdeath;
	private String[] mMoogles;
	private LinearLayout mLlMoogles;
	private int mCount = 0;
	private int mLeader = 0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle2);
        setView();
        mBtnChoose.setOnClickListener(btnChooseClick);
        mBtnBack.setOnClickListener(btnBackClick);
    }
	
	private void setView(){
		try{
			mBtnChoose = (Button) findViewById(R.id.btn_show_choose);
	        mBtnBack = (Button)findViewById(R.id.btn_back_to_pre);
	        mChkSephiroth = (CheckBox)findViewById(R.id.chk_sephiroth);
	        mChkSephiroth.setOnCheckedChangeListener(chkLeader);
	        mChkKefka = (CheckBox)findViewById(R.id.chk_kefka);
	        mChkKefka.setOnCheckedChangeListener(chkLeader);
	        mChkExdeath = (CheckBox)findViewById(R.id.chk_exdeath);
	        mChkExdeath.setOnCheckedChangeListener(chkLeader);
	        mLlMoogles = (LinearLayout)findViewById(R.id.ll_moogles);
	        mMoogles = getResources().getStringArray(R.array.moogles);
	        mTxtCounter = (TextView)findViewById(R.id.txt_counter);
	        mTxtLeader = (TextView)findViewById(R.id.txt_leader);
			for(int i=0; i<mMoogles.length; i++){
				CheckBox chkMoogle = new CheckBox(this);
				chkMoogle.setId(i);
				chkMoogle.setText(mMoogles[i]);
				chkMoogle.setOnCheckedChangeListener(chkMoogles);
				mLlMoogles.addView(chkMoogle);
			}
		} catch(Exception _ex){
			Log.e("aaaaaaa",_ex.getMessage());
		}
		
	}
	private OnCheckedChangeListener chkLeader = 
			new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(isChecked){
						mLeader++;
					} else {
						mLeader--;
					}
					mTxtLeader.setText(String.valueOf(mLeader));
				}
			}; 
	
	private OnCheckedChangeListener chkMoogles = 
		new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					mCount++;
				} else {
					mCount--;
				}
				mTxtCounter.setText(String.valueOf(mCount));
			}
		};
	
	
	private View.OnClickListener btnChooseClick = 
		new View.OnClickListener() {
			public void onClick(View v) {
				String message = "";
				
				if(mChkSephiroth.isChecked()){
					message += mChkSephiroth.getText().toString() + "\n";
				}
				if(mChkKefka.isChecked()){
					message += mChkKefka.getText().toString() + "\n";
				}
				if(mChkExdeath.isChecked()){
					message += mChkExdeath.getText().toString();
				}
				Toast.makeText(v.getContext(), message, Toast.LENGTH_LONG).show();
			}
		};
		
		private View.OnClickListener btnBackClick = 
			new View.OnClickListener() {
				public void onClick(View v) {
					finish();
				}
			};
		private TextView mTxtCounter;
		private TextView mTxtLeader;
		

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		    getMenuInflater().inflate(R.menu.moogle, menu);
		    return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			//使用這個函式時，系統會為我們傳入這個被選到的選單元件
		    //而這邊就是用 item.getItemId() 這個方法來得判斷是哪個選單被按到的
			switch(item.getItemId()){
				case R.id.menu_moogle:
					Intent intent = new Intent(this, Moogle3Activity.class);
					startActivity(intent);
					break;
			}
		    //這一行一定不能少
			return super.onOptionsItemSelected(item);
		}
}
