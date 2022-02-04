package id.kiadzaky.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewDataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView list_view;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list_view = findViewById(R.id.list_view);
        list_view.setOnItemClickListener(this);

        //get data method
        getJSON();

    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDataActivity.this,
                        "Mengambil data", "Tunggu Sebentar",
                        false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_GET_ALL);
                return result;
            }
            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();
                JSON_STRING = message;
//                Toast.makeText(ViewDataActivity.this, message, Toast.LENGTH_SHORT).show();
//                Log.d("DATA_JSON", JSON_STRING);
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
                String id = object.getString(Konfigurasi.TAG_JSON_ID);
                String name = object.getString(Konfigurasi.TAG_JSON_NAMA);

                HashMap<String, String> pegawai =new HashMap<>();
                pegawai.put(Konfigurasi.TAG_JSON_ID, id);
                pegawai.put(Konfigurasi.TAG_JSON_NAMA, name);

                // ubah format json ke array list
                list.add(pegawai);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //adapter untuk meletakan array list ke dalam list view
        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(), list, R.layout.activity_list_item,
                new String[]{Konfigurasi.TAG_JSON_ID, Konfigurasi.TAG_JSON_NAMA},
                new int[]{R.id.txt_id, R.id.txt_name}
        );
        list_view.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //list diklik akan tampilkan detail
        Intent i = new Intent(ViewDataActivity.this, ViewDetailDataActivity.class);
        HashMap<String,String> map = (HashMap) parent.getItemAtPosition(position);
        String pgwId = map.get(Konfigurasi.TAG_JSON_ID).toString();
        i.putExtra(Konfigurasi.PGW_ID, pgwId);
        startActivity(i);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}