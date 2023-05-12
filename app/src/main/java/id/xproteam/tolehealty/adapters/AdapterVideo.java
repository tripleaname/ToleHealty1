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
import id.xproteam.tolehealty.models.Video;

import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.MyViewHolder> {

    private Context context;
    private List<Video> videoList;
    RequestOptions options;

    public AdapterVideo(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.image_background).error(R.drawable.image_background);
    }

    @NonNull
    @Override
    public AdapterVideo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        final LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.video_row_item, viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.layoutVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(videoList.get(viewHolder.getAdapterPosition()).getStringLink()));
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.MyViewHolder myViewHolder, int i) {

        myViewHolder.textViewJudul.setText(videoList.get(i).getStringJudul());

        Glide.with(context).load(videoList.get(i).getStringGambar()).apply(options).into(myViewHolder.imageViewVideo);

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewVideo;
        TextView textViewJudul;
        LinearLayout layoutVideo;

        public MyViewHolder(View view) {
            super(view);

            layoutVideo = view.findViewById(R.id.rowVideo);
            imageViewVideo = view.findViewById(R.id.gambarVideo);
            textViewJudul = view.findViewById(R.id.judulVideo);
        }
    }
}