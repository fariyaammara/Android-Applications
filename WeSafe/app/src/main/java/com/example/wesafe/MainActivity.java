package com.example.wesafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button send_btn;
    Button edit_btn;
    TextView get_n1;
    TextView get_n2;
    SharedPreferences spf,spe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_btn=findViewById(R.id.reinsert);
        send_btn=findViewById(R.id.store);
        get_n1=(TextView)findViewById(R.id.get_numb1);
        get_n2=(TextView)findViewById(R.id.get_numb2);
        get_default();
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformSmsAction();
            }
        });
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformEditAction();
            }
        });
    }

    public void get_default() {
        SharedPreferences spf= getSharedPreferences("myspf",Context.MODE_PRIVATE);
        String stored_num1=spf.getString("fetch_numb1","value");
        String stored_num2=spf.getString("fetch_numb2","value");
        //Log.d("yes","aaaaaaaaaaaaaaaa"+stored_num2);
        get_n1.setText(stored_num1);
        get_n2.setText(stored_num2);

    }
    public void PerformSmsAction(){

        SharedPreferences spf=getSharedPreferences("myspf", Context.MODE_PRIVATE);
        SharedPreferences.Editor spe=spf.edit();
        spe.putString("fetch_numb1",get_n1.getText().toString());
        spe.putString("fetch_numb2",get_n2.getText().toString());
        spe.commit();
        finish();
        Toast.makeText(MainActivity.this, "your numb"+get_n1, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "beforeeeeeee", Toast.LENGTH_SHORT).show();
        set_text();
    }
    public  void set_text(){
        SharedPreferences spf=getSharedPreferences("myspf", Context.MODE_PRIVATE);
        String stored_num1=spf.getString("fetch_numb1","value");
        String stored_num2=spf.getString("fetch_numb2","value");
        Toast.makeText(MainActivity.this, "your numb2"+stored_num2, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "your numb1"+stored_num1, Toast.LENGTH_SHORT).show();
    }
    public void PerformEditAction(){
        get_n1.setText("");
        get_n2.setText("");
        PerformSmsAction();
    }
}