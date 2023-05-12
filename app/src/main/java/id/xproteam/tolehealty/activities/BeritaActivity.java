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
import id.xproteam.tolehealty.adapters.AdapterBerita;
import id.xproteam.tolehealty.models.Berita;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BeritaActivity extends AppCompatActivity {

    private final String stringJSON = "https://sahabatlansia.id/sl-api/Berita_API.php";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List <Berita> beritaList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        getSupportActionBar().setTitle("Berita Tole");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        beritaList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvBerita);
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
                        Berita berita = new Berita();
                        berita.setStringJudul(jsonObject.getString("judul"));
                        berita.setStringDeskripsi(jsonObject.getString("deskripsi"));
                        berita.setStringArtikel(jsonObject.getString("artikel"));
                        berita.setStringGambar(jsonObject.getString("gambar"));
                        berita.setStringTanggal(jsonObject.getString("tanggal"));
                        berita.setStringLink(jsonObject.getString("artikel"));
                        beritaList.add(berita);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setup(beritaList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(BeritaActivity.this);
        requestQueue.add(jsonArrayRequest);

    }

    private void setup(List<Berita> beritaList) {
        AdapterBerita adapterBerita = new AdapterBerita(this,beritaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapterBerita);
    }
}
