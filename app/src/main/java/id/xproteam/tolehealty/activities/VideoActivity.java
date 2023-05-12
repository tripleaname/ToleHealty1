package id.xproteam.tolehealty.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import id.xproteam.tolehealty.R;
import id.xproteam.tolehealty.adapters.AdapterVideo;
import id.xproteam.tolehealty.models.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {

    private final String stringJSON = "https://sahabatlansia.id/sl-api/Video_API.php";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List <Video> videoList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().setTitle("Video Tole");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvVideo);
        jsonrequest();
    }

    private void jsonrequest() {

        jsonArrayRequest = new JsonArrayRequest(stringJSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Video video = new Video();
                        video.setStringJudul(jsonObject.getString("judul"));
                        video.setStringLink(jsonObject.getString("link"));
                        video.setStringGambar(jsonObject.getString("gambar"));
                        videoList.add(video);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setup(videoList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(VideoActivity.this);
        requestQueue.add(jsonArrayRequest);

    }

    private void setup(List<Video> videoList) {
        AdapterVideo adapterVideo = new AdapterVideo(this, videoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapterVideo);
    }
}
