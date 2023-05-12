package id.xproteam.tolehealty.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import id.xproteam.tolehealty.R;
import id.xproteam.tolehealty.models.Berita;

import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {

    private Context context;
    private List<Berita> beritaList;
    RequestOptions options;

    public AdapterBerita(Context context, List<Berita> beritaList) {
        this.context = context;
        this.beritaList = beritaList;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.image_background).error(R.drawable.image_background);
    }

    @NonNull
    @Override
    public AdapterBerita.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        final LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.berita_row_item, viewGroup, false);
        final AdapterBerita.MyViewHolder viewHolder = new AdapterBerita.MyViewHolder(view);
        viewHolder.layoutBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(beritaList.get(viewHolder.getAdapterPosition()).getStringLink()));
                context.startActivity(intent);
            }
        });

        return viewHolder;


//        View view;
//        final LayoutInflater inflater = LayoutInflater.from(context);
//        view = inflater.inflate(R.layout.berita_row_item, viewGroup, false);
//        final MyViewHolder viewHolder = new MyViewHolder(view);
//        viewHolder.layoutBerita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ArtikelBeritaActivity.class);
//                intent.putExtra("judul", beritaList.get(viewHolder.getAdapterPosition()).getStringJudul());
//                intent.putExtra("tanggal", beritaList.get(viewHolder.getAdapterPosition()).getStringTanggal());
//                intent.putExtra("artikel", beritaList.get(viewHolder.getAdapterPosition()).getStringArtikel());
//                intent.putExtra("gambar", beritaList.get(viewHolder.getAdapterPosition()).getStringGambar());
//
//                context.startActivity(intent);
//            }
//        });
//
//        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerita.MyViewHolder myViewHolder, int i) {

        myViewHolder.textViewJudul.setText(beritaList.get(i).getStringJudul());
        myViewHolder.textViewDeskripsi.setText(beritaList.get(i).getStringDeskripsi());

        Glide.with(context).load(beritaList.get(i).getStringGambar()).apply(options).into(myViewHolder.imageViewBerita);

    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewBerita;
        TextView textViewJudul, textViewDeskripsi;
        LinearLayout layoutBerita;

        public MyViewHolder(View view) {
            super(view);

            layoutBerita = view.findViewById(R.id.rowBerita);
            imageViewBerita = view.findViewById(R.id.gambarBerita);
            textViewJudul = view.findViewById(R.id.judulBerita);
            textViewDeskripsi = view.findViewById(R.id.deskripsiBerita);
        }
    }
}
