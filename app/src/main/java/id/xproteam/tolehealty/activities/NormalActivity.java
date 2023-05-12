package id.xproteam.tolehealty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import id.xproteam.tolehealty.R;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);


        getSupportActionBar().setTitle("IMT Kesehatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Intent intent = getIntent();

        String nilai = intent.getStringExtra("normal");
        TextView textViewNormal = (TextView)findViewById(R.id.normal_nilai);

        textViewNormal.setText(nilai);
    }
}
