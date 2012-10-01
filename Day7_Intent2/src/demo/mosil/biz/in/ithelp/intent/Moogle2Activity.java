package demo.mosil.biz.in.ithelp.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Moogle2Activity extends Activity {
	private int mSignal;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moogle2);
        /* TODO: 取得暗號 */
        try{
            //取得包裹
        	Bundle bundleForMoogle1 = getIntent().getExtras();
            //再加兩個判斷式，確定包裹裡有我們要的訊息
        	if(bundleForMoogle1 != null && bundleForMoogle1.containsKey("Signal")){
        		mSignal = bundleForMoogle1.getInt("Signal");
        	}
        } catch(Exception ex){
        	mSignal = -1;
        }
        
        Button btnRequestToMoogle1 = (Button)findViewById(R.id.btn_request);
        btnRequestToMoogle1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: 被點擊後要執行的動作 */
				Intent intent = new Intent(Moogle2Activity.this, Moogle1Activity.class);
				String message;
			    /* 解析內容，請自行設定吧 */
				if(mSignal == -1){
					message = "回報！看不懂！";
				} else if(mSignal == 0) {
					message = "那我們就去休息了！";
				} else {
					message = "我們帶了" + String.valueOf(mSignal * 100) + "個弟兄來了！";
				}
			    /* 如法炮製，放入要回應的資訊 */
				Bundle bundleRequestMoogle1 = new Bundle();
				bundleRequestMoogle1.putInt("Signal", mSignal);
				bundleRequestMoogle1.putString("Message", message);
				intent.putExtras(bundleRequestMoogle1);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_moogle2, menu);
        return true;
    }
}
