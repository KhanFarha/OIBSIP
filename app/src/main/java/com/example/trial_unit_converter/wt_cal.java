package com.example.trial_unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class wt_cal extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText et_fromUnit,et_toUnit,measureFrom,measureTo;
    CardView cv_convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wt_cal);

        et_fromUnit = findViewById(R.id.et_fromUnit);

        cv_convert = findViewById(R.id.cv_convert);
        et_toUnit=findViewById(R.id.et_toUnit);
        sp1=findViewById(R.id.spFrom);
        sp2=findViewById(R.id.spTo);

        measureFrom=findViewById(R.id.measureFrom);
        measureTo=findViewById(R.id.measureTo);

        String[] from={"Kilograms (kg)", "Grams (g)", "Tons (t)"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad1);

        String[] to={"Kilograms (kg)", "Grams (g)", "Tons (t)"};
        ArrayAdapter ad2=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad2);

        et_fromUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Update etToUnit whenever etFromUnit text changes
                et_toUnit.setText("");

                measureTo.setText("");
                measureFrom.setText("");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Do nothing
            }
        });
        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converter();
            }
        });
    }

    private void converter(){
        String unitString=et_fromUnit.getText().toString();
        if(!unitString.isEmpty()){
            double original=Double.parseDouble(unitString);
            double converted;

            if(sp1.getSelectedItem().toString().equals("Kilograms (kg)") && sp2.getSelectedItem().toString().equals("Kilograms (kg)")){
                converted=original;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("kg");
                measureTo.setText("kg");
            }else if(sp1.getSelectedItem().toString().equals("Kilograms (kg)") && sp2.getSelectedItem().toString().equals("Grams (g)")){
                converted=original*1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("kg");
                measureTo.setText("g");
            }
            else if(sp1.getSelectedItem().toString().equals("Kilograms (kg)") && sp2.getSelectedItem().toString().equals("Tons (t)")){
                converted=original/1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("kg");
                measureTo.setText("t");
            }
            else if(sp1.getSelectedItem().toString().equals("Grams (g)") && sp2.getSelectedItem().toString().equals("Grams (g)")){
                converted=original;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("g");
                measureTo.setText("g");
            }
            else if(sp1.getSelectedItem().toString().equals("Grams (g)") && sp2.getSelectedItem().toString().equals("Kilograms (kg)")){

                converted=original/1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("g");
                measureTo.setText("kg");
            }
            else if(sp1.getSelectedItem().toString().equals("Grams (g)") && sp2.getSelectedItem().toString().equals("Tons (t)")){
                converted=original/1000000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("g");
                measureTo.setText("t");
            }
            else if(sp1.getSelectedItem().toString().equals("Tons (t)") && sp2.getSelectedItem().toString().equals("Tons (t)")){
                converted=original;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("t");
                measureTo.setText("t");
            }
            else if(sp1.getSelectedItem().toString().equals("Tons (t)") && sp2.getSelectedItem().toString().equals("Grams")){

                converted=original*1000000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("t");
                measureTo.setText("g");
            }
            else if(sp1.getSelectedItem().toString().equals("Tons (t)") && sp2.getSelectedItem().toString().equals("Kilograms (kg)")){
                converted=original*1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("t");
                measureTo.setText("kg");
            }
        }

        else{
            showToast("Please enter some value!");
        }
    }
    private void showToast(String message){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}