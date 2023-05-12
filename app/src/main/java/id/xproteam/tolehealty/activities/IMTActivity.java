package id.xproteam.tolehealty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import id.xproteam.tolehealty.R;

public class IMTActivity extends AppCompatActivity {
    EditText editTextBB, editTextTB;
    Button buttonHitung;
    RadioGroup radioGroupJK;
    RadioButton radioButtonJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

        getSupportActionBar().setTitle("IMT Kesehatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextBB = (EditText) findViewById(R.id.edit_text_bb);
        editTextTB = (EditText) findViewById(R.id.edit_text_tb);
        buttonHitung = (Button) findViewById(R.id.btn_hitung);
        radioGroupJK = (RadioGroup) findViewById(R.id.radioJK);


        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String isiBB = editTextBB.getText().toString();
                String isiTB = editTextTB.getText().toString();
                int radioId = radioGroupJK.getCheckedRadioButtonId();
                radioButtonJK = findViewById(radioId);

                if(editTextBB.length()==0){
                    Toast.makeText(getApplication(), "Berat Badan Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if (editTextTB.length()==0){
                    Toast.makeText(getApplication(), "Tinggi Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    double bb = Integer.parseInt(isiBB);
                    double tb = Integer.parseInt(isiTB);
                    tb /= 100;

                    double hasil = bb/(tb*tb);
                    int duaAngka = 2;
                    double temp = Math.pow(10, duaAngka);
                    double imt = (double) Math.round(hasil*temp)/temp;

                    String ket;

//                    Laki-laki
                    double ob = 27.0;
                    double gem = 25.1;
                    double norm = 18.5;

////                    Perempuan
//                    if(isiJK.equals("p") || isiJK.equals("P")) {
//                        gem = 25;
//                        norm = 18;
//                    }

                    if(imt>ob) {
                        String nilai = Double.toString(imt);
                        ket = "Obesitas";
                        Intent intent = new Intent(IMTActivity.this, ObesitasActivity.class);
                        intent.putExtra("obesitas", nilai);
                        startActivity(intent);
                    }
                    else if (imt>gem) {
                        String nilai = Double.toString(imt);
                        ket = "Gemuk";
                        Intent intent = new Intent(IMTActivity.this, GemukActivity.class);
                        intent.putExtra("gemuk", nilai);
                        startActivity(intent);
                    }
                    else if (imt>norm) {
                        String nilai = Double.toString(imt);
                        ket = "Normal";
                        Intent intent = new Intent(IMTActivity.this, NormalActivity.class);
                        intent.putExtra("normal", nilai);
                        startActivity(intent);
                    }
                    else {
                        String nilai = Double.toString(imt);
                        ket = "Kurus";
                        Intent intent = new Intent(IMTActivity.this, KurusActivity.class);
                        intent.putExtra("kurus", nilai);
                        startActivity(intent);
                    }

                    Toast.makeText(getApplication(), radioButtonJK.getText()+" "+ket+" "+imt , Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}