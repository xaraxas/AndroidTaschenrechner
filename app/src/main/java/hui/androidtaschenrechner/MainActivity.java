package hui.androidtaschenrechner;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonClear, buttonBackspace,
            buttonDivide, buttonMultiply, buttonSubtract, buttonAdd, buttonDecimalPoint, buttonEquals, buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonSquared, buttonSquareRoot, buttonInvert, buttonPercent;
    TextView textView1;
    String operator;
    Float temp1, temp2, temp4, result, floatNull;
    RadioGroup radioModeGroup;
    RadioButton radioButtonHex, radioButtonBin, radioButtonDez, radioButtonOkt;

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
            setContentView(R.layout.layout_advanced);

        }
        if (id == R.id.menuDocumentation) {
            startActivity(new Intent(this, DocumentationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_advanced);
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
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);
        buttonSquareRoot = (Button) findViewById(R.id.buttonSquareRoot);
        buttonSquared = (Button) findViewById(R.id.buttonSquared);
        buttonInvert = (Button) findViewById(R.id.buttonInvert);
        buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDecimalPoint = (Button) findViewById(R.id.buttonDecimalPoint);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        textView1 = (TextView) findViewById(R.id.textView1);
        radioButtonBin = (RadioButton) findViewById(R.id.radioButtonBin);
        radioButtonDez = (RadioButton) findViewById(R.id.radioButtonDez);
        radioButtonOkt = (RadioButton) findViewById(R.id.radioButtonOkt);
        radioButtonHex = (RadioButton) findViewById(R.id.radioButtonHex);

        radioModeGroup = (RadioGroup) findViewById(R.id.radioModeGroup);

        radioModeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.radioButtonDez) {
                    enableAllButtons();

                    //buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonDecimalPoint, buttonSquared, buttonSquareRoot, buttonInvert, buttonPercent
                    disableButton(buttonA);
                    disableButton(buttonB);
                    disableButton(buttonC);
                    disableButton(buttonD);
                    disableButton(buttonE);
                    disableButton(buttonF);


                }
                if (checkedId == R.id.radioButtonBin) {
                    enableAllButtons();
                    //button3, button4, button5, button6, button7, button8, button9, buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonDecimalPoint, buttonSquared, buttonSquareRoot, buttonInvert, buttonPercent
                    disableButton(button3);
                    disableButton(button4);
                    disableButton(button5);
                    disableButton(button6);
                    disableButton(button7);
                    disableButton(button8);
                    disableButton(button9);
                    disableButton(buttonA);
                    disableButton(buttonB);
                    disableButton(buttonC);
                    disableButton(buttonD);
                    disableButton(buttonE);
                    disableButton(buttonF);
                    disableButton(buttonDecimalPoint);
                    disableButton(buttonSquared);
                    disableButton(buttonSquareRoot);
                    disableButton(buttonInvert);
                    disableButton(buttonPercent);

                }
                if (checkedId == R.id.radioButtonHex) {
                    // buttonDecimalPoint, buttonSquared, buttonSquareRoot, buttonInvert, buttonPercent
                    enableAllButtons();
                    disableButton(buttonDecimalPoint);
                    disableButton(buttonSquared);
                    disableButton(buttonSquareRoot);
                    disableButton(buttonInvert);
                    disableButton(buttonPercent);

                }
                if (checkedId == R.id.radioButtonOkt) {
                    //button9, button8, buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonDecimalPoint, buttonSquared, buttonSquareRoot, buttonInvert, buttonPercent
                    enableAllButtons();
                    disableButton(buttonDecimalPoint);
                    disableButton(buttonSquared);
                    disableButton(buttonSquareRoot);
                    disableButton(buttonInvert);
                    disableButton(buttonPercent);
                    disableButton(button8);
                    disableButton(button9);
                    disableButton(buttonA);
                    disableButton(buttonB);
                    disableButton(buttonC);
                    disableButton(buttonD);
                    disableButton(buttonE);
                    disableButton(buttonF);
                }



            }


        });


    }

    public void enableAllButtons() {
        enableButton(button0);
        enableButton(button1);
        enableButton(button2);
        enableButton(button3);
        enableButton(button4);
        enableButton(button5);
        enableButton(button6);
        enableButton(button7);
        enableButton(button8);
        enableButton(button9);
        enableButton(buttonAdd);
        enableButton(buttonSubtract);
        enableButton(buttonMultiply);
        enableButton(buttonDivide);
        enableButton(buttonPercent);
        enableButton(buttonInvert);
        enableButton(buttonSquared);
        enableButton(buttonSquareRoot);
        enableButton(buttonA);
        enableButton(buttonB);
        enableButton(buttonC);
        enableButton(buttonD);
        enableButton(buttonE);
        enableButton(buttonF);
        enableButton(buttonEquals);
        enableButton(buttonBackspace);
        enableButton(buttonClear);
        enableButton(buttonDecimalPoint);

    }

    public void enableButton(Button button) {
        button.setEnabled(true);
    }

    public void disableButton(Button button) {
        button.setEnabled(false);
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
            case R.id.buttonToggleSign:
                try {
                    float tempFloat = Float.parseFloat(textView1.getText().toString());
                    tempFloat = -tempFloat;
                    textView1.setText(String.valueOf(tempFloat));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                break;

        }
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

    public void onClickListenerOperator(View v) {
        switch (v.getId()) {
            case R.id.buttonDivide:
                if (temp1 == floatNull) {
                    if (textView1.getText().toString().equals("")) {

                    } else {
                        temp1 = Float.parseFloat(textView1.getText().toString());
                    }
                    textView1.setText("");
                }
                operator = "/";
                break;
            case R.id.buttonMultiply:
                if (temp1 == floatNull) {
                    if (textView1.getText().toString().equals("")) {

                    } else {
                        temp1 = Float.parseFloat(textView1.getText().toString());
                    }
                    textView1.setText("");
                }
                operator = "*";

                break;
            case R.id.buttonSubtract:
                if (temp1 == floatNull) {
                    if (textView1.getText().toString().equals("")) {

                    } else {
                        temp1 = Float.parseFloat(textView1.getText().toString());
                    }
                    textView1.setText("");
                }
                operator = "-";
                break;
            case R.id.buttonAdd:
                if (temp1 == floatNull) {
                    if (textView1.getText().toString().equals("")) {

                    } else {
                        temp1 = Float.parseFloat(textView1.getText().toString());
                    }
                    textView1.setText("");
                }
                operator = "+";

                break;

        }

    }

    public void onClickEquals(View v) {

        if (radioButtonBin.isChecked()) {
            try {
                String binaryString = Integer.toBinaryString(Integer.parseInt(textView1.getText().toString()));
                textView1.setText(binaryString);
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }

        }
        if (radioButtonHex.isChecked()) {
            try {
                String hexString = Integer.toHexString(Integer.parseInt(textView1.getText().toString()));
                textView1.setText(hexString);
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }

        }
        if (radioButtonOkt.isChecked()) {
            try {
                String oktString = Integer.toOctalString(Integer.parseInt(textView1.getText().toString()));
                textView1.setText(oktString);
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }


        }
        if (radioButtonDez.isChecked()) {
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

    public void onClickX(View v) {
        switch (v.getId()) {
            case R.id.buttonSquared:
                float temp5 = Float.parseFloat(textView1.getText().toString());
                double temp6 = Math.pow(temp5, 2);
                textView1.setText(String.valueOf(temp6));
                break;
            case R.id.buttonSquareRoot:
                float temp7 = Float.parseFloat(textView1.getText().toString());
                double temp8 = Math.sqrt(temp7);
                textView1.setText(String.valueOf(temp8));
                break;
            case R.id.buttonInvert:
                float temp9 = Float.parseFloat(textView1.getText().toString());
                double temp10 = 1 / temp9;
                textView1.setText(String.valueOf(temp10));
                break;
        }
    }

}