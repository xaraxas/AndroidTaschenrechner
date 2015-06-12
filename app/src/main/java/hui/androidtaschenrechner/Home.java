package hui.androidtaschenrechner;

/**
 * Created by HuiaPro on 10.06.2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Thread th = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    onPause();
                    startActivity(new Intent("calc.CALC"));
                }
            }
        };
        th.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }
}

