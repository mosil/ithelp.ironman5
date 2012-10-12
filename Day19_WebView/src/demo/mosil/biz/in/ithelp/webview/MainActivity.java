package demo.mosil.biz.in.ithelp.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private WebView mWvWeb;
	private EditText mEdtUrl;
	private Button mBtnGo;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://blog.mosil.biz";
        mWvWeb = (WebView)findViewById(R.id.wv_web);
        mWvWeb.loadUrl(url);
        
        mEdtUrl = (EditText)findViewById(R.id.edt_url);
        mBtnGo = (Button)findViewById(R.id.btn_go_link);
        mBtnGo.setOnClickListener(btnClickLis);
    }
	
	private View.OnClickListener btnClickLis = 
			new View.OnClickListener() {
				public void onClick(View v) {
					String url = mEdtUrl.getText().toString();
					mWvWeb.loadUrl(url);
				}
			};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
