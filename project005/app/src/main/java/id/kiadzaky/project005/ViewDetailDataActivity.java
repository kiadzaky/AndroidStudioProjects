package id.kiadzaky.project005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ViewDetailDataActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_id, edit_name, edit_desg, edit_salary;
    private Button btn_edit_employee, btn_delete_employee;
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
        btn_delete_employee = findViewById(R.id.btn_delete_employee);
        btn_edit_employee = findViewById(R.id.btn_edit_employee);
        //menerima intent dari class view data
        Intent receive = getIntent();
        id = receive.getStringExtra(Konfigurasi.PGW_ID);
        edit_id.setText(id);
        //mengambil data JSON
        getJSON();
        btn_edit_employee.setOnClickListener(this);
        btn_delete_employee.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        if (view == btn_edit_employee){
            updateDataEmployee();
        }else if(view == btn_delete_employee){
            confirmDeleteDataEmployee();
        }
    }

    private void confirmDeleteDataEmployee() {
        // konfirmasi
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah Anda Yakin Menghapus?");
        alert.setMessage("Data yang akan dihapus: ");
        alert.setIcon(getResources().getDrawable(android.R.drawable.ic_delete));
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", null);
        alert.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteEmployee();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void deleteEmployee() {
        class DeleteDataEmployee extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDetailDataActivity.this,
                        "Delete Data", "Harap Tunggu",
                        false,false);
            }

            @Override
            protected String doInBackground(Void... voids) {

                HttpHandler handler = new HttpHandler();
                String result = handler.sendGetResponse(Konfigurasi.URL_DELETE, id);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewDetailDataActivity.this, "Berhasil Delete Data" + s, Toast.LENGTH_SHORT).show();
                //redirect ke view data
                startActivity(new Intent(ViewDetailDataActivity.this, ViewDataActivity.class));
                Log.d("Status",s );
            }
        }

        DeleteDataEmployee deleteDataEmployee = new DeleteDataEmployee();
        deleteDataEmployee.execute();
    }

    private void updateDataEmployee() {
        // data apa saja yang akan diubah
        final String nama = edit_name.getText().toString().trim();
        final String jabatan = edit_desg.getText().toString().trim();
        final String gaji = edit_salary.getText().toString().trim();

        class UpdateDataEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewDetailDataActivity.this,
                        "Ubah Data", "Harap Tunggu",
                        false,false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_PGW_ID, id);
                params.put(Konfigurasi.KEY_PGW_NAMA, nama);
                params.put(Konfigurasi.KEY_PGW_JABATAN, jabatan);
                params.put(Konfigurasi.KEY_PGW_GAJI, gaji);

                HttpHandler handler = new HttpHandler();
                String result = handler.sendPostRequest(Konfigurasi.URL_UPDATE, params);
                return result;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewDetailDataActivity.this, "Berhasil Update Data" + s, Toast.LENGTH_SHORT).show();
                //redirect ke view data
                startActivity(new Intent(ViewDetailDataActivity.this, ViewDataActivity.class));

            }
        }
        UpdateDataEmployee updateDataEmployee = new UpdateDataEmployee();
        updateDataEmployee.execute();
    }
}