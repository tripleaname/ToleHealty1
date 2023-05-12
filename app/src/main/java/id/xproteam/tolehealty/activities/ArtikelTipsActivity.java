package id.xproteam.tolehealty.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import id.xproteam.tolehealty.R;

public class ArtikelTipsActivity extends AppCompatActivity {

    RequestOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_tips);

        getSupportActionBar().setTitle("Tips Tole");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String stringJudul = getIntent().getExtras().getString("judul");
        String stringArtikel = getIntent().getExtras().getString("artikel");
        String stringTanggal = getIntent().getExtras().getString("tanggal");
        String stringGambar = getIntent().getExtras().getString("gambar");

        TextView textViewJudul = findViewById(R.id.judulArtikelTips);
        TextView textViewArtikel = findViewById(R.id.artikelTips);
        TextView textViewTanggal = findViewById(R.id.tanggalArtikelTips);
        ImageView imageViewGambar = findViewById(R.id.gambarArtikelTips);

        textViewJudul.setText(stringJudul);
        textViewArtikel.setText(stringArtikel);
        textViewTanggal.setText(stringTanggal);

        options = new RequestOptions().centerCrop().placeholder(R.drawable.image_background).error(R.drawable.image_background);

        Glide.with(this).load(stringGambar).into(imageViewGambar);
    }
}
