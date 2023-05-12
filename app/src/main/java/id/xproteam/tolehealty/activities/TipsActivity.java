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
import id.xproteam.tolehealty.adapters.AdapterTips;
import id.xproteam.tolehealty.models.Tips;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends AppCompatActivity {

    private final String stringJSON = "https://sahabatlansia.id/sl-api/Tips_API.php";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List <Tips> tipsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        getSupportActionBar().setTitle("Tips Tole");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tipsList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvTips);
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
                        Tips tips = new Tips();
                        tips.setStringJudul(jsonObject.getString("judul"));
                        tips.setStringDeskripsi(jsonObject.getString("deskripsi"));
                        tips.setStringArtikel(jsonObject.getString("artikel"));
                        tips.setStringGambar(jsonObject.getString("gambar"));
                        tips.setStringTanggal(jsonObject.getString("tanggal"));
                        tips.setStringLink(jsonObject.getString("artikel"));
                        tipsList.add(tips);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setup(tipsList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(TipsActivity.this);
        requestQueue.add(jsonArrayRequest);

    }

    private void setup(List<Tips> tipsList) {
        AdapterTips adapterTips = new AdapterTips(this, tipsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapterTips);
    }
}
