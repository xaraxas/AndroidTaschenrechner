/*
 * ActShowHelp.java
 * Android-Anwendungsentwicklung
 */

package hui.androidtaschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Activity zur Anzeige der HTML-Onlinehilfe. Oberfläche: layout/show_help.xml
 *
 * @author Wolfgang Lang
 * @version 1.0.7, 2014-11-02
 */
public class DocumentationActivity extends Activity {

    private static final String MIMETYPE = "text/html";
    private static final String ENCODING = "UTF-8";

    /*-----------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_documentation);

        final WebView view = (WebView) findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);

    /*
     * Die Hilfe lässt sich auch von einem Server laden mit: view.loadUrl(
     * "http://www.lehre-online.net/..." );
     *
     * Ggf. lassen sich auch unterschiedliche HTML-Seiten aufrufen. In diesem
     * Fall wird die id für openRawResource() im Intent-Bundle übergeben.
     * Beispiel: final Bundle extras = getIntent().getExtras(); if( (extras !=
     * null) && (extras.containsKey( KEY_MY_HELP )) ) int id = extras.getInt(
     * KEY_MY_HELP );
     */

        InputStream is = getResources().openRawResource(R.raw.documentation);

        try {
            if ((is != null) && is.available() > 0) {
                final byte[] bytes = new byte[is.available()];
                is.read(bytes);
                view.loadDataWithBaseURL(null, new String(bytes), MIMETYPE,
                        ENCODING, null);
        /*
         * Alternativ geht auch: view.loadData( new String( bytes ), MIMETYPE,
         * ENCODING );
         */
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        view.bringToFront();
    }
}