package com.example.trial_unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class vol_cal extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText et_fromUnit,et_toUnit,measureFrom,measureTo;
    CardView cv_convert;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_cal);

        et_fromUnit = findViewById(R.id.et_fromUnit);

        cv_convert = findViewById(R.id.cv_convert);
        et_toUnit=findViewById(R.id.et_toUnit);
        sp1=findViewById(R.id.spFrom);
        sp2=findViewById(R.id.spTo);
        measureFrom=findViewById(R.id.measureFrom);
        measureTo=findViewById(R.id.measureTo);

        String[] from={"Millilitres (ml)", "Litres (l)"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad1);

        String[] to={"Millilitres (ml)", "Litres (l)"};
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
    @SuppressLint("DefaultLocale")
    private void converter(){
        String unitString=et_fromUnit.getText().toString();
        if(!unitString.isEmpty()){
            double original=Double.parseDouble(unitString);
            double converted;

            if(sp1.getSelectedItem().toString().equals("Millilitres (ml)") && sp2.getSelectedItem().toString().equals("Millilitres (ml)")){
                converted=original;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText("ml");
                measureTo.setText("ml");
            }else if(sp1.getSelectedItem().toString().equals("Millilitres (ml)") && sp2.getSelectedItem().toString().equals("Litres (l)")){
                converted=original/1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText(String.format("ml"));
                measureTo.setText(String.format("l"));
            }
            else if(sp1.getSelectedItem().toString().equals("Litres (l)") && sp2.getSelectedItem().toString().equals("Litres (l)")){
                converted=original;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText(String.format("l"));
                measureTo.setText(String.format("l"));
            }
            else if(sp1.getSelectedItem().toString().equals("Litres (l)") && sp2.getSelectedItem().toString().equals("Millilitres (ml)")){
                converted=original*1000;
                et_toUnit.setText(String.format("%2f", converted));
                measureFrom.setText(String.format("l"));
                measureTo.setText(String.format("ml"));
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