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

    ImageButton measureActivityLauncher, productFinderActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measureActivityLauncher=(ImageButton)findViewById(R.id.measureActivityLauncher);
        productFinderActivityLauncher=(ImageButton)findViewById(R.id.productFinderActivityLauncher);

        measureActivityLauncher.setOnClickListener(this);
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

            case R.id.productFinderActivityLauncher:
                i=new Intent(MainActivity.this, SearchForProducts.class);
                MainActivity.this.startActivity(i);
                break;

        }
    }


}
