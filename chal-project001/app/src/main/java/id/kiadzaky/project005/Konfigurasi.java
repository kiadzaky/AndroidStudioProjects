package id.kiadzaky.project005;

public class Konfigurasi {

    public static final String LINK = "http://192.168.1.54/pegawai/";
    //pegawai
    public static final String URL_GET_ALL = LINK+"tampilSemuaPgw.php";
    public static final String URL_GET_DETAIL = LINK+"tampilPgw.php?id=";
    public static final String URL_ADD = LINK+"tambahPgw.php";
    public static final String URL_UPDATE = LINK+"updatePgw.php";
    public static final String URL_DELETE = LINK +"hapusPgw.php";
    //nasabah
    public static final String URL_GET_NASABAH = LINK+"tampilSemuaNasabah.php";
    public static final String URL_GET_DETAIL_NASABAH = LINK+"tampilNasabah.php?id=";

    // data json berisi key dan value yang ada di browser
    public static final String KEY_PGW_ID = "id";
    public static final String KEY_PGW_NAMA = "name";
    public static final String KEY_PGW_JABATAN = "desg";
    public static final String KEY_PGW_GAJI = "salary";

    //data json berisi key khusus nasabah

    public static final String KEY_JSON_NASABAH_ID = "id";
    public static final String KEY_JSON_NASABAH_NAMA = "name";
    public static final String KEY_JSON_NASABAH_SALDO = "balance";
    public static final String KEY_JSON_NASABAH_ALAMAT = "address";
    public static final String KEY_JSON_NASABAH_TELP = "number";
    public static final String KEY_JSON_NASABAH_PEKERJAAN = "job";

    // ARRAY
    public static final String TAG_JSON_ARRAY = "result";
    //flag JSON pegawai
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAMA = "name";
    public static final String TAG_JSON_JABATAN = "desg";
    public static final String TAG_JSON_GAJI = "salary";

    //flag JSON NASABAH
    public static final String TAG_JSON_NASABAH_ID = "id";
    public static final String TAG_JSON_NASABAH_NAMA = "name";
    public static final String TAG_JSON_NASABAH_SALDO = "balance";
    public static final String TAG_JSON_NASABAH_ALAMAT = "address";
    public static final String TAG_JSON_NASABAH_TELP = "number";
    public static final String TAG_JSON_NASABAH_PEKERJAAN = "job";

    //variabel ID PEGAWAI
    public static final String PGW_ID = "emp_id";
    //variabel ID NASABAH
    public static final String NSBH_ID = "cust_id";
}
