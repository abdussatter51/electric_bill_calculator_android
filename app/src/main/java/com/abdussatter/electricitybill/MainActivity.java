package com.abdussatter.electricitybill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout resultLayout, resultLayoutAlways;
    EditText edUnit;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultLayout = findViewById(R.id.resultLayout);
        resultLayoutAlways = findViewById(R.id.resultLayoutAlways);
        edUnit = findViewById(R.id.edUnit);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unit = edUnit.getText().toString();
                float slot50 = 0, slot150 = 0, slot250 = 0, slotAbove250 = 0;
                float unitBill = Float.parseFloat(unit);
                if (unit.length()>0){
                    if (unitBill<=50){
                        slot50 = (float) (unitBill*0.50);
                    }
                    else if (unitBill<=150){
                        slot50 = (float) (50*0.50);
                        slot150 = (float) ((unitBill-50)*0.75);
                    }
                    else if (unitBill<=250){
                        slot50 = (float) (50*0.50);
                        slot150 = (float) (100*0.75);
                        slot250 = (float) ((unitBill-150)*1.20);
                    }
                    else {
                        slot50 = (float) (50*0.50);
                        slot150 = (float) (100*0.75);
                        slot250 = (float) (100*1.20);
                        slotAbove250 = (float) ((unitBill-250)*1.50);
                    }
                    float electricBill = slot50+slot150+slot250+slotAbove250;
                    float sureCharge = (float) (electricBill*0.20);
                    float totalBill = electricBill+sureCharge;
                    tvResult.setText(totalBill+"");
                }
                else{
                    edUnit.setError("Please input your unit.");
                }
                resultLayout.setVisibility(View.VISIBLE);
                resultLayoutAlways.setVisibility(View.GONE);
            }
        });

    }
}