package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
		final String message;
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
				
			    
			    //初始化物件
		        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		    	//設定標題
		        dialog.setTitle("回覆的內容 ");
				//設定內容
		        dialog.setMessage(message);
		        //設定圖示
		    	dialog.setIcon(android.R.drawable.ic_dialog_alert);
		    	//讓三(四)天王鍵的返回功能失效
		    	dialog.setCancelable(false);
		    	dialog.setPositiveButton("接收", new DialogInterface.OnClickListener() {
		    		public void onClick(DialogInterface dialog, int which) {
		    			//用吐司(Toast)來傳出訊息
					    Toast.makeText(Moogle1Activity.this, message, Toast.LENGTH_LONG).show();
					}
					
				});
		    	dialog.setNegativeButton("無視", new DialogInterface.OnClickListener() {
		    		public void onClick(DialogInterface dialog, int which) {
		    			
					}
					
				});
		        dialog.show();
			}
		} catch(Exception ex){
			
		}
		
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle1, menu);
        return true;
    }
}
