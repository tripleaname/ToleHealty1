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
import id.xproteam.tolehealty.models.Tips;

import java.util.List;

public class AdapterTips extends RecyclerView.Adapter<AdapterTips.MyViewHolder> {

    private Context context;
    private List<Tips> tipsList;
    RequestOptions options;

    public AdapterTips(Context context, List<Tips> tipsList) {
        this.context = context;
        this.tipsList = tipsList;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.image_background).error(R.drawable.image_background);
    }

    @NonNull
    @Override
    public AdapterTips.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        final LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.tips_row_item, viewGroup, false);
        final AdapterTips.MyViewHolder viewHolder = new AdapterTips.MyViewHolder(view);
        viewHolder.layoutTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(tipsList.get(viewHolder.getAdapterPosition()).getStringLink()));
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTips.MyViewHolder myViewHolder, int i) {

        myViewHolder.textViewJudul.setText(tipsList.get(i).getStringJudul());
        myViewHolder.textViewDeskripsi.setText(tipsList.get(i).getStringDeskripsi());

        Glide.with(context).load(tipsList.get(i).getStringGambar()).apply(options).into(myViewHolder.imageViewTips);

    }

    @Override
    public int getItemCount() {
        return tipsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewTips;
        TextView textViewJudul, textViewDeskripsi;
        LinearLayout layoutTips;

        public MyViewHolder(View view) {
            super(view);

            layoutTips = view.findViewById(R.id.rowTips);
            imageViewTips = view.findViewById(R.id.gambarTips);
            textViewJudul = view.findViewById(R.id.judulTips);
            textViewDeskripsi = view.findViewById(R.id.deskripsiTips);
        }
    }
}
