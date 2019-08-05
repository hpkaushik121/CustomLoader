package tech.kaushik.sourabh.com.customeloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tech.kaushik.sourabh.com.customeloader.VIewActivities.ProgressDots;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CustomLoader(View view) {
        Intent customLoaderIntent= new Intent(MainActivity.this, ProgressDots.class);
        startActivity(customLoaderIntent);
    }


}
