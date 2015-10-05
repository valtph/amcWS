package com.phvalt.amcws.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.phvalt.amcws.R;


public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton measureActivityLauncher,measureActivity2Launcher,measureActivity3Launcher, productFinderActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measureActivityLauncher=(ImageButton)findViewById(R.id.measureActivityLauncher);
        measureActivity2Launcher=(ImageButton)findViewById(R.id.measureActivity2Launcher);
        measureActivity3Launcher=(ImageButton)findViewById(R.id.measureActivity3Launcher);

        productFinderActivityLauncher=(ImageButton)findViewById(R.id.productFinderActivityLauncher);

        measureActivityLauncher.setOnClickListener(this);
        measureActivity2Launcher.setOnClickListener(this);
        measureActivity3Launcher.setOnClickListener(this);
        productFinderActivityLauncher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;

        switch(v.getId()){
            case R.id.measureActivityLauncher:
                i=new Intent(MainActivity.this, AccelerometerDisplay.class);
                MainActivity.this.startActivity(i);
                break;

            case R.id.measureActivity2Launcher:
                i=new Intent(MainActivity.this, AccelerometerDisplay2.class);
                MainActivity.this.startActivity(i);
                break;

            case R.id.measureActivity3Launcher:
                i=new Intent(MainActivity.this, AccelerometerDisplay3.class);
                MainActivity.this.startActivity(i);
                break;

            case R.id.productFinderActivityLauncher:
                i=new Intent(MainActivity.this, SearchForProducts.class);
                MainActivity.this.startActivity(i);
                break;

        }
    }


}
