package id.kiadzaky.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewDataNasabahActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView list_view_nasabah;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data_nasabah);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DATA NASABAH");
        list_view_nasabah = findViewById(R.id.list_view_nasabah);
        list_view_nasabah.setOnItemClickListener(this);

        //get data method
        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDataNasabahActivity.this,
                        "Mengambil data", "Tunggu Sebentar",
                        false, false);

                //time out loading
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        loading.cancel();
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(runnable, 10000);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_NASABAH);
                return result;
            }
            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
//                loading.dismiss();
                JSON_STRING = message;
                displayAllData();
            }
        }
        GetJSON get_json = new GetJSON();
        get_json.execute();
    }

    private void displayAllData() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            for (int i =0; i < result.length(); i++){
                JSONObject object = result.getJSONObject(i);
                String id = object.getString(Konfigurasi.TAG_JSON_NASABAH_ID);
                String name = object.getString(Konfigurasi.TAG_JSON_NASABAH_NAMA);
                String balance = object.getString(Konfigurasi.TAG_JSON_NASABAH_SALDO);

                HashMap<String, String> nasabah =new HashMap<>();
                nasabah.put(Konfigurasi.TAG_JSON_NASABAH_ID, id);
                nasabah.put(Konfigurasi.TAG_JSON_NASABAH_NAMA, name);
                nasabah.put(Konfigurasi.TAG_JSON_NASABAH_SALDO, balance);

                // ubah format json ke array list
                list.add(nasabah);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //adapter untuk meletakan array list ke dalam list view
        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list, R.layout.activity_list_item,
                new String[]{Konfigurasi.TAG_JSON_NASABAH_ID, Konfigurasi.TAG_JSON_NASABAH_NAMA,
                        Konfigurasi.TAG_JSON_NASABAH_SALDO},
                // mengikuti di activity list item
                new int[]{R.id.txt_id, R.id.txt_name, R.id.txt_gaji}

        );
        list_view_nasabah.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(ViewDataNasabahActivity.this, ViewDetailDataNasabahActivity.class);
        HashMap<String,String> map = (HashMap) parent.getItemAtPosition(position);
        String cust_id = map.get(Konfigurasi.TAG_JSON_NASABAH_ID).toString();
        i.putExtra(Konfigurasi.NSBH_ID, cust_id);
        startActivity(i);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}