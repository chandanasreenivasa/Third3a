package com.example.chandanasrinivas.third3a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    TextView textdisplay;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    private static final String KEY_FIRSTNAME="firstname_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }

        textdisplay=(TextView) findViewById(R.id.textView);
        if (savedInstanceState!= null) {
            String savedName=savedInstanceState.getString(KEY_FIRSTNAME);
            textdisplay.setText(savedName);

        }
        else
            Toast.makeText(this,"NEW ENTRY",Toast.LENGTH_SHORT).show();

    }

    public void onSaveInstance(Bundle savedInstanceState){
        savedInstanceState.putString(KEY_FIRSTNAME,textdisplay.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void Save(View view) {
        String n = name.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.commit();
        textdisplay.setText(name.getText().toString());
    }

    public void clear(View view) {
        name = (EditText) findViewById(R.id.etName);
        name.setText("");

    }

    public void Get(View view) {
        name = (EditText) findViewById(R.id.etName);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
