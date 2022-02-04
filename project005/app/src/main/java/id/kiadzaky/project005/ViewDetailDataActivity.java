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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViewDetailDataActivity extends AppCompatActivity {
    private EditText edit_id, edit_name, edit_desg, edit_salary;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Data Pegawai");

        edit_id = findViewById(R.id.edit_id);
        edit_name = findViewById(R.id.edit_name);
        edit_desg = findViewById(R.id.edit_desg);
        edit_salary = findViewById(R.id.edit_salary);

        //menerima intent dari class view data
        Intent receive = getIntent();
        id = receive.getStringExtra(Konfigurasi.PGW_ID);
        edit_id.setText(id);

        //mengambil data JSON
        getJSON();

    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDetailDataActivity.this,
                        "Mengambil data", "Tunggu Sebentar",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_DETAIL, id);
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

            String nama = object.getString(Konfigurasi.TAG_JSON_NAMA);
            String jabatan = object.getString(Konfigurasi.TAG_JSON_JABATAN);
            String gaji = object.getString(Konfigurasi.TAG_JSON_GAJI);

            Log.d("data", nama);

            edit_name.setText(nama);
            edit_desg.setText(jabatan);
            edit_salary.setText(gaji);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}