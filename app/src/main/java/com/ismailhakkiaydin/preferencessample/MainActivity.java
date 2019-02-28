package com.ismailhakkiaydin.preferencessample;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.SharedLibraryInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp = this.getPreferences(Context.MODE_PRIVATE);
        edt= sp.edit();

        edt.putInt("a",555);
        edt.commit();

        sp.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                Toast.makeText(MainActivity.this,s + " değişti",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void btn_Click (View view){
        if (sp.contains("a")){
            edt.putInt("a",333);
            edt.commit();
        }
    }

}
