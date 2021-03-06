package hui.androidtaschenrechner;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonClear, buttonBackspace,
            buttonDivide, buttonMultiply, buttonSubtract, buttonAdd, buttonDecimalPoint, buttonEquals;
    TextView textView1;
    String operator;
    Float temp1, temp2, temp4, result, floatNull;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.menuLayoutSimple) {
            setContentView(R.layout.activity_main);
        }
        if (id == R.id.menuLayoutAdvanced) {
            startActivity(new Intent(this, AdvancedActivity.class));

        }
        if (id == R.id.menuDocumentation) {
            startActivity(new Intent(this, DocumentationActivity.class));
        }
        if (id == R.id.menuAbout) {
            startActivity(new Intent(this, AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDecimalPoint = (Button) findViewById(R.id.buttonDecimalPoint);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        textView1 = (TextView) findViewById(R.id.textView1);

    }

    public void onClickListenerDelete(View v) {
        switch (v.getId()) {
            case R.id.buttonBackspace:

                String temp3 = textView1.getText().toString();
                if (temp3.length() != 0) {
                    textView1.setText(temp3.substring(0, temp3.length() - 1));
                }
                break;

            case R.id.buttonClear:
                textView1.setText("");
                temp1 = floatNull;
                temp2 = floatNull;

                break;

        }
    }

    public void onClickListenerNum(View v) {
        switch (v.getId()) {

            case R.id.button0:
                textView1.append("0");
                break;

            case R.id.button1:
                textView1.append("1");
                break;
            case R.id.button2:
                textView1.append("2");
                break;
            case R.id.button3:
                textView1.append("3");
                break;
            case R.id.button4:
                textView1.append("4");
                break;
            case R.id.button5:
                textView1.append("5");
                break;
            case R.id.button6:
                textView1.append("6");
                break;
            case R.id.button7:
                textView1.append("7");
                break;
            case R.id.button8:
                textView1.append("8");
                break;
            case R.id.button9:
                textView1.append("9");
                break;
            case R.id.buttonDecimalPoint:
                textView1.append(".");
                break;

        }
    }

    public void onClickListenerOperator(View v) {
        switch (v.getId()) {
            case R.id.buttonDivide:
                if (temp1 == floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "/";
                break;
            case R.id.buttonMultiply:
                if (temp1 == floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "*";

                break;
            case R.id.buttonSubtract:
                if (temp1 == floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "-";
                break;
            case R.id.buttonAdd:
                if (temp1 == floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "+";

                break;

        }

    }

    public void onClickEquals(View v) {

        if (textView1.getText().toString().equals("")) {

        } else {

            temp2 = Float.parseFloat(textView1.getText().toString());
        }
        if (temp1 != null) {

            if (operator.equals("/")) {
                result = temp1 / temp2;
                temp1 = null;
                temp2 = null;
                textView1.setText(String.valueOf(result));

            }
            if (operator.equals("+")) {
                result = temp1 + temp2;
                temp1 = null;
                temp2 = null;
                textView1.setText(String.valueOf(result));

            }
            if (operator.equals("*")) {
                result = temp1 * temp2;
                temp1 = null;
                temp2 = null;
                textView1.setText(String.valueOf(result));

            }
            if (operator.equals("-")) {
                result = temp1 - temp2;
                temp1 = null;
                temp2 = null;
                textView1.setText(String.valueOf(result));

            }
        } else {
            if (textView1.getText().toString().equals("")) {

            } else {
                temp4 = Float.parseFloat(textView1.getText().toString());
                textView1.setText(temp4.toString());
            }
        }

    }

}