package demo.mosil.biz.in.ithelp.choose;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Moogle2Activity extends Activity {

    private Button mBtnChoose;
	private Button mBtnBack;
	private CheckBox mChkSephiroth;
	private CheckBox mChkKefka;
	private CheckBox mChkExdeath;
	private String[] mMoogles;
	private LinearLayout mLlMoogles;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle2);
        setView();
        mBtnChoose.setOnClickListener(btnChooseClick);
        mBtnBack.setOnClickListener(btnBackClick);
    }
	
	private void setView(){
		mBtnChoose = (Button) findViewById(R.id.btn_show_choose);
        mBtnBack = (Button)findViewById(R.id.btn_back_to_pre);
        mChkSephiroth = (CheckBox)findViewById(R.id.chk_sephiroth);
        mChkKefka = (CheckBox)findViewById(R.id.chk_kefka);
        mChkExdeath = (CheckBox)findViewById(R.id.chk_exdeath);
        mLlMoogles = (LinearLayout)findViewById(R.id.ll_moogles);
        mMoogles = getResources().getStringArray(R.array.moogles);
		for(int i=0; i<mMoogles.length; i++){
			CheckBox chkMoogle = new CheckBox(this);
			chkMoogle.setId(i);
			chkMoogle.setText(mMoogles[i]);
			mLlMoogles.addView(chkMoogle);
		}
	}
	
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
		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle2, menu);
        return true;
    }
}
