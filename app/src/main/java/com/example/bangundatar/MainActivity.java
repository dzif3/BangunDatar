package com.example.bangundatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtAlas, edtTinggi;
    Button btnHitung, btnClear;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlas = findViewById(R.id.edtAlas);
        edtTinggi = findViewById(R.id.edtTinggi);
        btnHitung = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        btnClear = findViewById(R.id.btnClear);

        btnHitung.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate){
            String alas = edtAlas.getText().toString().trim();
            String tinggi =  edtTinggi.getText().toString().trim();

            boolean isEmpty = false;

            if (TextUtils.isEmpty(alas)){
                isEmpty = true;
                edtAlas.setError("Button Panjang tidak boleh kosong !");
            }

            if (TextUtils.isEmpty(tinggi)){
                isEmpty = true;
                edtTinggi.setError("Button Panjang Tidak boleh kosong !");
            }

            if (!isEmpty){
                double a = Double.parseDouble(alas);
                double t = Double.parseDouble(tinggi);

                double volume = 0.5 * a * t;
                tvResult.setText(String.valueOf(volume));

            }
        }

        if (v.getId()== R.id.btnClear){
            edtAlas.setText("");
            edtTinggi.setText("");
            tvResult.setText("");
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}