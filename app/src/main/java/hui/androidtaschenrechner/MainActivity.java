package hui.androidtaschenrechner;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonClear, buttonBackspace,
            buttonDivide, buttonMultiply, buttonSubtract, buttonAdd, buttonDecimalPoint, buttonEquals;
    TextView textView1;
    String operator;
    Float temp1, temp2, result,floatNull;

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
                textView1.append(",");
                break;
            case R.id.buttonBackspace:


                break;

            case R.id.buttonClear:

                break;
        }
    }

    public void onClickListenerOperator(View v) {
        switch (v.getId()) {
            case R.id.buttonDivide:
                if (temp1==floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "/";
                break;
            case R.id.buttonMultiply:
                if (temp1==floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "*";

                break;
            case R.id.buttonSubtract:
                if (temp1==floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "-";
                break;
            case R.id.buttonAdd:
                if (temp1==floatNull) {
                    temp1 = Float.parseFloat(textView1.getText().toString());
                    textView1.setText("");
                }
                operator = "+";

                break;

        }

    }

    public void onClickEquals(View v) {

        temp2 = Float.parseFloat(textView1.getText().toString());


        if (operator.equals("/")) {
            float result =temp1/temp2;
            temp1=null;
            temp2=null;
            textView1.setText(String.valueOf(result));

        }
        if (operator.equals("+")) {
            float result =temp1+temp2;
            temp1=null;
            temp2=null;
            textView1.setText(String.valueOf(result));

        }
        if (operator.equals("*")) {
            float result =temp1*temp2;
            temp1=null;
            temp2=null;
            textView1.setText(String.valueOf(result));

        }
        if (operator.equals("-")) {
            float result =temp1-temp2;
            temp1=null;
            temp2=null;
            textView1.setText(String.valueOf(result));

        }
    }

}