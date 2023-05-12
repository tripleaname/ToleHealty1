package id.xproteam.tolehealty.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.xproteam.tolehealty.R;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewBerita, cardViewVideo, cardViewTips, cardViewIMT;
    private Dialog dialog;
    private ImageView imageViewCloseIMT, imageViewCloseTips, imageViewCloseVideo, imageViewCloseBerita;
    private Button buttonPopupIMT, buttonPopupTips, buttonPopupVideo, buttonPopupBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewBerita = (CardView) findViewById(R.id.cv_berta);
        cardViewVideo = (CardView) findViewById(R.id.cv_video);
        cardViewTips = (CardView) findViewById(R.id.cv_tips);
        cardViewIMT = (CardView) findViewById(R.id.cv_imt);

        dialog = new Dialog(this);

        cardViewBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeritaPopup();
            }
        });

        cardViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoPopup();
            }
        });

        cardViewTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipsPopup();
            }
        });

        cardViewIMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMTPopup();
            }
        });
    }

    private void IMTPopup() {
        dialog.setContentView(R.layout.popup_imt);
        imageViewCloseIMT = (ImageView) dialog.findViewById(R.id.closePopupIMT);
        buttonPopupIMT = (Button) dialog.findViewById(R.id.btnPopupIMT);

        imageViewCloseIMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonPopupIMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IMTActivity.class);
                v.getContext().startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void TipsPopup() {
        dialog.setContentView(R.layout.popup_tips);
        imageViewCloseTips = (ImageView) dialog.findViewById(R.id.closePopupTips);
        buttonPopupTips = (Button) dialog.findViewById(R.id.btnPopupTips);

        imageViewCloseTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonPopupTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TipsActivity.class);
                v.getContext().startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void VideoPopup() {
        dialog.setContentView(R.layout.popup_video);
        imageViewCloseVideo = (ImageView) dialog.findViewById(R.id.closePopupVideo);
        buttonPopupVideo = (Button) dialog.findViewById(R.id.btnPopupVideo);

        imageViewCloseVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonPopupVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoActivity.class);
                v.getContext().startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void BeritaPopup() {
        dialog.setContentView(R.layout.popup_berita);
        imageViewCloseBerita = (ImageView) dialog.findViewById(R.id.closePopupBerita);
        buttonPopupBerita = (Button) dialog.findViewById(R.id.btnPopupBerita);

        imageViewCloseBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonPopupBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BeritaActivity.class);
                v.getContext().startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
