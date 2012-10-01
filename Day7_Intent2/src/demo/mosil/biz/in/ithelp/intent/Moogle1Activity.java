package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Moogle1Activity extends Activity {
	private Button mBtnCallMoogle2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle1);
        mBtnCallMoogle2 = (Button)findViewById(R.id.btn_call_moogle2);
        mBtnCallMoogle2.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v) {
    			/* TODO: 被點擊後要執行的動作 */
    			Intent intent = new Intent(Moogle1Activity.this, Moogle2Activity.class);
    			//亂數取一個0~10的數值
    			int signal = (int)(Math.random()*10) + 1;
    			Bundle bundle = new Bundle();
    			//關鍵字(key)為"Signal"，值是亂數產生的一個隨機值
    			bundle.putInt("Signal", signal);
    			intent.putExtras(bundle);
    			startActivity(intent);
    		}
        });
    }

    @Override
	protected void onStart() {
		super.onStart();
		String message;
		int signal;
		
		try{
			//取得 Moogle2 傳來的包裹
			Bundle bundleFromMoogle2 = getIntent().getExtras();
			if(bundleFromMoogle2 != null){
				//解譯 Moogle2 傳來的訊息
				signal = (bundleFromMoogle2.containsKey("Signal"))? 
						bundleFromMoogle2.getInt("Signal") : -1;
				if(signal == -1){
					message = "找出有問題的地方後，再重傳一次吧！";
				} else {
					message = (bundleFromMoogle2.containsKey("Message")) ? 
							bundleFromMoogle2.getString("Message") : "回報兵被殲滅！";
				}
				//用吐司(Toast)來傳出訊息
			    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
			}
		} catch(Exception ex){
			message = "無法解譯！";
		}
		
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle1, menu);
        return true;
    }
}
