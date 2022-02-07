package id.kiadzaky.project005;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class TambahPegawaiActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_nama, edit_jabatan, edit_gaji;
    private Button btn_input_employee, btn_view_employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pegawai);

        edit_nama = findViewById(R.id.edit_nama);
        edit_jabatan = findViewById(R.id.edit_jabatan);
        edit_gaji = findViewById(R.id.edit_gaji);
        btn_input_employee = findViewById(R.id.btn_input_employee);
        btn_view_employee = findViewById(R.id.btn_view_employee);

        btn_input_employee.setOnClickListener(this);
        btn_view_employee.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btn_view_employee){
            startActivity(new Intent(TambahPegawaiActivity.this, ViewDataActivity.class));
        }
        else if (view == btn_input_employee){
            String nama = edit_nama.getText().toString().trim();
            String jabatan = edit_jabatan.getText().toString().trim();
            String gaji = edit_gaji.getText().toString().trim();
            if(nama.matches("") && jabatan.matches("") && gaji.matches("")){
                Toast.makeText(this, "Wajib Isi Data", Toast.LENGTH_SHORT).show();
            }else{

                saveDataEmployee(nama, jabatan, gaji);
            }

        }
    }

    private void saveDataEmployee(String nama, String jabatan, String gaji) {
        // fields apa saja yang akan disimpan


        class SaveDataEmployee extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahPegawaiActivity.this, "Save Data",
                        "Harap Tunggu", false,false);

            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_PGW_NAMA, nama);
                params.put(Konfigurasi.KEY_PGW_JABATAN, jabatan);
                params.put(Konfigurasi.KEY_PGW_GAJI, gaji);

                HttpHandler handler = new HttpHandler();
                String result = handler.sendPostRequest(Konfigurasi.URL_ADD, params);

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahPegawaiActivity.this, "Berhasil Simpan Data "+ s, Toast.LENGTH_SHORT).show();
                clearText();
            }
        }
        SaveDataEmployee sdp = new SaveDataEmployee();
        sdp.execute();
    }

    private void clearText() {
        edit_nama.setText("");
        edit_gaji.setText("");
        edit_jabatan.setText("");
        edit_nama.requestFocus();
    }
}