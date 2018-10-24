package com.bjh.www.a1017_gridlayoutcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    int i = 0;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        this.setTitle("그리드 레이아웃 계산기");

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        txtResult = (TextView)findViewById(R.id.txtResult);

        for(i=0; i<numBtnIDs.length; i++)
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);

        for(i=0; i<numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        if (edit1.isFocused()) {
                                                            imm.hideSoftInputFromWindow(edit1.getWindowToken(), 0);
                                                            num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                                                            edit1.setText(num1);
                                                        }
                                                        else if (edit2.isFocused()) {
                                                            imm.hideSoftInputFromWindow(edit2.getWindowToken(), 0);
                                                            num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                                                            edit2.setText(num2);
                                                        }
                                                        else
                                                            Toast.makeText(getApplicationContext(), "먼저 입력텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                                                    }
                                                 });
        }

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                txtResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                txtResult.setText("계산결과: " + result);
                return false;
            }
        });
    }
}