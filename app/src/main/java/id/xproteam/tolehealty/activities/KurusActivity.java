package id.xproteam.tolehealty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import id.xproteam.tolehealty.R;

public class KurusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurus);


        getSupportActionBar().setTitle("IMT Kesehatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Intent intent = getIntent();

        String nilai = intent.getStringExtra("kurus");
        TextView textViewKurus = (TextView)findViewById(R.id.kurus_nilai);

        textViewKurus.setText(nilai);
    }
}
