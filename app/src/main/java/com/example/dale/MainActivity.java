package com.example.dale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Fragment fragment;
FragmentManager fragmentManager;
FragmentTransaction fragmentTransaction;
SharedPreferences sharedPreferences;
Boolean FirstTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);

sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);
FirstTime = sharedPreferences.getBoolean("FirstTime",true);
if (FirstTime) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    FirstTime = false;
    editor.putBoolean("FirstTime", FirstTime);
    editor.apply();
    addfragmentsplash();
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        public void run() {
            addfragmentloginFirst();
        }
    }, 2500);   //5 seconds
}
else {
    addfragmentlogin();

}

    }
    public void addfragmentloginFirst(){
      fragmentTransaction.remove(fragment);

        fragment = new FragmentLogin();

fragmentManager = getSupportFragmentManager();
fragmentTransaction = fragmentManager.beginTransaction();
//fragmentTransaction.addToBackStack(null);
fragmentTransaction.add(R.id.fragmentContainer,fragment);
fragmentTransaction.commit();

    }
    public void addfragmentsplash(){

        fragment = new FragmentSplashscreen();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();

    }
    public void addfragmentlogin(){

        fragment = new FragmentLogin();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();

    }
}
