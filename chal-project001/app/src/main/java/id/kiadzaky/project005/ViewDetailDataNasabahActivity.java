package id.kiadzaky.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViewDetailDataNasabahActivity extends AppCompatActivity {
    private EditText edit_nasabah_id, edit_nasabah_nama, edit_nasabah_alamat,
        edit_nasabah_telepon, edit_nasabah_pekerjaan, edit_nasabah_saldo;
    private String id;
    private TextView txt_detail_nasabah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_data_nasabah);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edit_nasabah_id = findViewById(R.id.edit_nasabah_id);
        edit_nasabah_nama = findViewById(R.id.edit_nasabah_nama);
        edit_nasabah_alamat = findViewById(R.id.edit_nasabah_alamat);
        edit_nasabah_telepon = findViewById(R.id.edit_nasabah_telepon);
        edit_nasabah_pekerjaan = findViewById(R.id.edit_nasabah_pekerjaan);
        edit_nasabah_saldo = findViewById(R.id.edit_nasabah_saldo);
        txt_detail_nasabah = findViewById(R.id.txt_detail_nasabah);

        //menerima intent dari class view data
        Intent receive = getIntent();
        id = receive.getStringExtra(Konfigurasi.NSBH_ID);
        edit_nasabah_id.setText(id);

        //mengambil data JSON
        getJSON();

    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDetailDataNasabahActivity.this,
                        "Mengambil data", "Tunggu Sebentar",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_DETAIL_NASABAH, id);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                displayDetailData(message);
            }
        }
        GetJSON get_json = new GetJSON();
        get_json.execute();
    }

    private void displayDetailData(String json) {
        try {
            JSONObject json_object = new JSONObject(json);
            JSONArray result = json_object.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject object = result.getJSONObject(0);

            String name = object.getString(Konfigurasi.TAG_JSON_NASABAH_NAMA);
            String address = object.getString(Konfigurasi.TAG_JSON_NASABAH_ALAMAT);
            String number = object.getString(Konfigurasi.TAG_JSON_NASABAH_TELP);
            String job = object.getString(Konfigurasi.TAG_JSON_NASABAH_PEKERJAAN);
            String balance = object.getString(Konfigurasi.TAG_JSON_NASABAH_SALDO);

            edit_nasabah_nama.setText(name);
            edit_nasabah_alamat.setText(address);
            edit_nasabah_telepon.setText(number);
            edit_nasabah_pekerjaan.setText(job);
            edit_nasabah_saldo.setText(balance);

            txt_detail_nasabah.setText("Detail Nasabah " + name);
            getSupportActionBar().setTitle("Detail Nasabah " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}