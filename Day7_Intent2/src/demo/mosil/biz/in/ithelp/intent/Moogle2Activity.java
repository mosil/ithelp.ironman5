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
        /* TODO: ���o�t�� */
        try{
            //���o�]�q
        	Bundle bundleForMoogle1 = getIntent().getExtras();
            //�A�[��ӧP�_���A�T�w�]�q�̦��ڭ̭n���T��
        	if(bundleForMoogle1 != null && bundleForMoogle1.containsKey("Signal")){
        		mSignal = bundleForMoogle1.getInt("Signal");
        	}
        } catch(Exception ex){
        	mSignal = -1;
        }
        
        Button btnRequestToMoogle1 = (Button)findViewById(R.id.btn_request);
        btnRequestToMoogle1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* TODO: �Q�I����n���檺�ʧ@ */
				Intent intent = new Intent(Moogle2Activity.this, Moogle1Activity.class);
				String message;
			    /* �ѪR���e�A�Цۦ�]�w�a */
				if(mSignal == -1){
					message = "�^���I�ݤ����I";
				} else if(mSignal == 0) {
					message = "���ڭ̴N�h�𮧤F�I";
				} else {
					message = "�ڭ̱a�F" + String.valueOf(mSignal * 100) + "�ӧ̥S�ӤF�I";
				}
			    /* �p�k���s�A��J�n�^������T */
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