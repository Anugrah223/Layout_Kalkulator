package com.example.layout_kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, persen, tambah, kurang, kali, bagi, hasil, Hapus, titik, Backspace;
    TextView angkaMasuk, angkaKeluar;
    String process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        bagi = findViewById(R.id.bagi);
        kali = findViewById(R.id.kali);

        hasil = findViewById(R.id.hasil);

        Hapus = findViewById(R.id.Hapus);
        titik = findViewById(R.id.titik);
        persen = findViewById(R.id.persen);
        Backspace = findViewById(R.id.Backspace);

        angkaMasuk = findViewById(R.id.angkaMasuk);
        angkaKeluar = findViewById(R.id.angkaKeluar);

        Hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angkaMasuk.setText("");
                angkaKeluar.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "9");
            }
        });

        persen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "%");
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "+");
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "-");
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "x");
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "÷");
            }
        });


        Hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + "AC");
            }
        });

        titik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaKeluar.setText(process + ".");
            }
        });

        Backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = angkaMasuk.getText().toString();
                int input = word.length();
                if (input > 0 ){
                    angkaMasuk.setText(word.substring(0, input -1));
                }
            }
        });

        hasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                org.mozilla.javascript.Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                angkaKeluar.setText(finalResult);
            }

        }));

    }
}