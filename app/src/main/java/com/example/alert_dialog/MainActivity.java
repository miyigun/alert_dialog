package com.example.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define();
    }

    private void define() {
        buton = (Button) findViewById(R.id.openDialog);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogOpen();
            }
        });
    }

    public void dialogOpen() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertlayout, null);

        EditText mailEditText = (EditText) view.findViewById(R.id.mailAddress);
        EditText userNameEditText = (EditText) view.findViewById(R.id.user);
        EditText passwordEditText = (EditText) view.findViewById(R.id.password);

        Button buton = (Button) view.findViewById(R.id.buton);
        Button buton2 = (Button) view.findViewById(R.id.buton2);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), mailEditText.getText().toString()
                                + " " + userNameEditText.getText().toString() + " " + passwordEditText.getText().toString()
                        , Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

}