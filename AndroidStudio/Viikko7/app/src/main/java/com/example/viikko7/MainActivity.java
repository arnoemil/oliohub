package com.example.viikko7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView textField;
    EditText text;
    TextView fileName;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = (TextView) findViewById(R.id.textView);
        text = (EditText) findViewById(R.id.textToFile);
        fileName = (TextView) findViewById(R.id.fileName);
        text.addTextChangedListener(tw);
        context = MainActivity.this;
        System.out.println("Kansion sijainti: "+ context.getFilesDir());
    }

    TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            textField.setText(text.getText());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void readFile(View v) {
        System.out.println("Hello World!");
        try {
            InputStream ins = context.openFileInput(String.valueOf(fileName.getText()));

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";

            while((s = br.readLine()) != null) {
                System.out.println(s);
                text.setText(s);
            }
            ins.close();
        } catch (FileNotFoundException e) {
            Log.e("FileNotFound", "Ei tiedostoa");
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("Tiedosto luettu.");
        }

    }

    public void writeFile(View v) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(String.valueOf(fileName.getText()), Context.MODE_PRIVATE));

            ows.write(String.valueOf(text.getText()));
            ows.close();
        } catch (IOException e) {
            Log.e("FileNotFound", "Virhe");
        } finally {
            System.out.println("Tiedosto kirjoitettu.");
        }

    }
}