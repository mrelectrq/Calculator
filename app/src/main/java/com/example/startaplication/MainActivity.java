package com.example.startaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
    private double val1 = 0;
    private double val2 = 0;
    private double result = 0;
    private char check;
    private String Edit;
    private RecyclerView numberList;
    private TextView resultCalc;
    public String result_string2;
    final ArrayList<String> rezultatele = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView/////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////
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
                Edit = resultCalc.getText() + "";

                if (Edit.contains(".")) {

                } else {

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

                if (resultCalc.getText().length() == 1) {

                    resultCalc.setText(null);
                    resultCalc.setHint("0");

                } else {
                    resultCalc.setText(back("" + resultCalc.getText()));
                    resultCalc.setHint(null);
                }
            }
        });


        add = findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                val1 = Double.parseDouble( resultCalc.getText()+"");
                val2 = Double.parseDouble(resultCalc.getText()+"");

                check_operation();
                calculation();
                check = ADUNARE;
                resultCalc.setHint(formatValue(result)+"");
                resultCalc.setText("");


                // Add char to string recycler

            }
        });

        sub = findViewById(R.id.button_subb);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble( resultCalc.getText()+"");
                val2 = Double.parseDouble(resultCalc.getText()+"");
                check_operation();
                calculation();
                check = SCADERE;
                resultCalc.setHint(formatValue(result)+"");
                resultCalc.setText("");


            }
        });

        div = findViewById(R.id.impartire);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble( resultCalc.getText()+"");
                val2 = Double.parseDouble(resultCalc.getText()+"");
                check_operation();
                calculation();
                check = IMPARTIRE;
                resultCalc.setHint(formatValue(result)+"");
                resultCalc.setText("");


            }
        });

        mul = findViewById(R.id.button_mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble( resultCalc.getText()+"");
                val2 = Double.parseDouble(resultCalc.getText()+"");
                check_operation();
                calculation();
                check = INMULTIRE;
                resultCalc.setHint(formatValue(result)+"");
                resultCalc.setText("");

            }
        });

        equal = findViewById(R.id.button_equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                val1 = Double.parseDouble( resultCalc.getText()+"");
                val2 = Double.parseDouble(resultCalc.getText()+"");
                calculation();


                resultCalc.setText(formatValue(result));

                if (check==ADUNARE) { result_string2 += "+" + formatValue(val2); }
                    else if (check==SCADERE) { result_string2 += "-" + formatValue(val2); }
                    else if (check==INMULTIRE) { result_string2 += "*" + formatValue(val2); }
                    else if (check==IMPARTIRE) { result_string2 += "/" + formatValue(val2); }



                rezultatele.add(result_string2+"=" + formatValue(result));
                recylcleInit();
                result_string2=null;
            }
        });
    }

    public void recylcleInit() {
        numberList = findViewById(R.id.recycler_view);
        numberList.setLayoutManager(new LinearLayoutManager(this));
        numberList.setHasFixedSize(true);
        StringsAdapter adapter = new StringsAdapter(this, rezultatele);
        numberList.setAdapter(adapter);

    }


    public String back(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
            return str;
        } else return str;
    }


    public void check_operation(){
        if (result_string2==null)
        {
            result_string2=formatValue(val2);
        }
        else if(check==ADUNARE) {result_string2 += "+" + formatValue(val2);}
        else if(check==INMULTIRE) {result_string2 += "*" + formatValue(val2);}
        else if(check==IMPARTIRE) {result_string2 += "/" + formatValue(val2);}
        else if(check==SCADERE) {result_string2 += "-" + formatValue(val2);}
    }



    public void adunare()
    {
        if(result==0) {result+=val1;}
        else {result+=val2;}

    }

    public void scadere()
    {
        if(result==0) {result+=val1;}
        else {result-=val2;}
    }

    public void impartire()
    {
        if(result==0) {result+=val1;}
        else {result/=val2;}
    }

    public void inmultire()
    {
        if(result==0) {result+=val1;}
        else {result*=val2;}
    }

    public String formatValue(double d) {
        String dStr = String.valueOf(d);
        return dStr.matches("\\d+\\.\\d*[1-9]\\d*") ? dStr : dStr.substring(0, dStr.indexOf("."));
    }

    public void calculation() {


        switch (check) {
            case ADUNARE:
                    adunare();
                break;

            case SCADERE:
                scadere();
                break;


            case INMULTIRE:
                inmultire();
                break;

            case IMPARTIRE:
                impartire();
                break;

                default:
                    adunare();

        }
    }
}



