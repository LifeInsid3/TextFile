package com.example.zadanchtototam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText Texti1;
    TextView Texti2;

    String file = "writefile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Texti1 = findViewById(R.id.Txt1);
        Texti2 = findViewById(R.id.Txt2);
    }

    public void write(View view) {
        FileOutputStream fileOutputStream =null;
        try {
            String text = Texti1.getText().toString();
            fileOutputStream = openFileOutput(file,MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            Toast.makeText(this, "Информация записана", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileOutputStream!=null){fileOutputStream.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void read(View view) {
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = openFileInput(file);
            byte [] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String text = new String(bytes);
            Texti2.setText(text);
            Toast.makeText(this, "Ваша информация", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream!=null){fileInputStream.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}