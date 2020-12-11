package com.osinfosoft.cheggcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //Declaration of views
    private TextInputEditText quesEt, rateEt;
    private TextView resTv;
    private TextInputLayout quesEtLayout, rateEtLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooking declared views
        quesEt = findViewById(R.id.ques_et);
        rateEt = findViewById(R.id.rate_et);
        resTv = findViewById(R.id.res_tv);
        quesEtLayout = findViewById(R.id.ques_et_layout);
        rateEtLayout = findViewById(R.id.rate_et_layout);

    }

    //Function when user click on Enter function
    public void enterClickedFunc(View view) {

        //Taking input of both editText fields
        String quesEtInput = quesEt.getText().toString().trim();
        String rateEtInput = rateEt.getText().toString().trim();

        if (quesEtInput.isEmpty()) {
            quesEtLayout.setError("Can't be empty");
            quesEtLayout.requestFocus();
            resTv.setVisibility(View.GONE);
        } else if (rateEtInput.isEmpty()) {
            rateEtLayout.setError("Can't be empty");
            rateEtLayout.requestFocus();
            resTv.setVisibility(View.GONE);
        } else {
            int questions = Integer.parseInt(quesEtInput);
            int rate = Integer.parseInt(rateEtInput);

            double tds = 7.5;
            int grossAmount = questions * rate;
            int finalAmount = grossAmount - (int) (grossAmount * (tds / 100));

            resTv.setText(String.format("Your payment (approx) : %s", finalAmount));
            resTv.setVisibility(View.GONE);
            resTv.animate().alpha(1).setDuration(800);
            resTv.setVisibility(View.VISIBLE);

            quesEtLayout.setError(null);
            rateEtLayout.setError(null);
        }
    }

    //Function when clear button will be clicked
    public void clearClickedFunc(View view) {
        resTv.setVisibility(View.GONE);
    }
}