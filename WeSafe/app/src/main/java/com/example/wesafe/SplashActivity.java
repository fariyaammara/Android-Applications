package com.example.wesafe;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(((ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(SplashActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION))==PackageManager.PERMISSION_GRANTED)&&((ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED)&&
                (ContextCompat.checkSelfPermission(SplashActivity.this,Manifest.permission.SEND_SMS))==PackageManager.PERMISSION_GRANTED))
        {
            Log.d("yes","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
        }
            else{
                String[] get_permissions={Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_CONTACTS,Manifest.permission.SEND_SMS};
                ActivityCompat.requestPermissions(SplashActivity.this, get_permissions, 200);
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }




        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            }
    }
