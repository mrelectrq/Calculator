package com.example.startaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView dot;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button equal;
    private Button remove;
    private TextView clear;
    private final char ADUNARE = '+';
    private final char SCADERE = '-';
    private final char INMULTIRE = '*';
    private final char IMPARTIRE = '/';
    private double val1=0;
    private double val2=0;
    private double result=0;
    private char check;
    private String Edit;

    private TextView resultCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.button_one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "1");
            }
        });
        resultCalc = findViewById(R.id.resultCalc);

        two = findViewById(R.id.button_two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "2");
            }
        });

        three = findViewById(R.id.button_three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "3");
            }
        });

        four = findViewById(R.id.button_four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "4");
            }
        });

        five = findViewById(R.id.button_five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "5");
            }
        });

        six = findViewById(R.id.button_six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "6");
            }
        });

        seven = findViewById(R.id.button_seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "7");
            }
        });

        eight = findViewById(R.id.button_eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "8");
            }
        });

        nine = findViewById(R.id.button_nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "9");
            }
        });

        zero = findViewById(R.id.button_zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCalc.setText(resultCalc.getText() + "0");
            }
        });


        dot = findViewById(R.id.button_dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Edit=resultCalc.getText()+"";

                if(Edit.contains(".")) {

                }
                else {

                    resultCalc.setText(resultCalc.getText() + ".");
                }
            }
        });

        clear = findViewById(R.id.acCalc);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = val1 = result = 0;
                resultCalc.setText(null);
                resultCalc.setHint("0");
            }
        });


        remove = findViewById(R.id.back);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resultCalc.getText().length()==1)
                {

                    resultCalc.setText(null);
                    resultCalc.setHint("0");

                }
                else {
                    resultCalc.setText(back("" + resultCalc.getText()));
                    resultCalc.setHint(null);
                }
                //Edit = resultCalc.getText()+"";
            }
        });


        add = findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = ADUNARE;
                val1 = Double.parseDouble("0"+resultCalc.getText()) ;
                resultCalc.setHint(resultCalc.getText());
                resultCalc.setText(null);
            }
        });

        sub = findViewById(R.id.button_subb);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = SCADERE;

                val1 = Double.parseDouble("0"+resultCalc.getText());
                resultCalc.setHint(resultCalc.getText());
                resultCalc.setText(null);
            }
        });

        div = findViewById(R.id.impartire);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = IMPARTIRE;
                val1 = Double.parseDouble("0"+ resultCalc.getText()) ;
                resultCalc.setHint(resultCalc.getText());
                resultCalc.setText(null);

            }
        });

        mul = findViewById(R.id.button_mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = INMULTIRE;
                val1 = Double.parseDouble("0"+ resultCalc.getText());
                resultCalc.setHint(resultCalc.getText());
                resultCalc.setText(null);


            }
        });

        equal = findViewById(R.id.button_equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    val2 = Double.parseDouble("0"+ resultCalc.getText() );
                    calculation();

            }
        });
    }

    public String back(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
            return str;
        }
        else return str;
    }



    public String formatValue(double d) {
        String dStr = String.valueOf(d);
        return dStr.matches("\\d+\\.\\d*[1-9]\\d*") ? dStr : dStr.substring(0, dStr.indexOf("."));
    }

    public void calculation() {


        switch (check) {
            case ADUNARE:
                result = val1 + val2;
                resultCalc.setText(formatValue(result) );
                break;
            case INMULTIRE:

                resultCalc.setText(formatValue(val1 * val2) );
                break;
            case SCADERE:
                result = val1-val2;

                resultCalc.setText(formatValue(result));
                break;
            case IMPARTIRE:

                result=val1/val2;
                resultCalc.setText(formatValue(result));
                break;
        }
    }
}



