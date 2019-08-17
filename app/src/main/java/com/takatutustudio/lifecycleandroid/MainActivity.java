package com.takatutustudio.lifecycleandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    TextView txtTodo;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);

        txtTodo = (TextView) findViewById(R.id.txtTodo);
        finish = (Button) findViewById(R.id.finish);

        //informasi life cycle
        String informasi = "Lifecycle Arsitektur \n "
                + "1. New Instance (onCreate, onStart, onResume) \n"
                + "2. Back Arrow (onPause, onStop, onDestroy) \n"
                + "3. Finish (onPause, onStop, onDestroy) \n"
                + "4. Reopen App (onRestart, onStart, onResume) \n"
                + "5. Home (onPause, onStop) \n"
                + "6. A receiver a phone call/sms (onPause, onResume) \n"
                + "7 Roterate (vertical ke horizontal) \n"
                + "(onPause, onStop, onDestroy, onCreate, onStart, onResume)";

        txtTodo.setText(informasi);
        Toast.makeText(getBaseContext(), "onCreate", Toast.LENGTH_LONG).show();

        //Button Finish
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // ( fungsinya sama dengan logout )
            }
        });

    }//eo onCreate


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(), "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(), "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(), "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(), "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(), "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(), "onDestroy", Toast.LENGTH_LONG).show();

        //cara menghapus atau melakukan uninstal aplikasi pada level destroy
        Uri packageuri = Uri.parse("package:com.takatutustudio.lifecycleandroid");
        Intent intent = new Intent(Intent.ACTION_DELETE,packageuri);
        startActivity(intent);
    }
}
