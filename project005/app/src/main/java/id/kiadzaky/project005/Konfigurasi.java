package id.kiadzaky.project005;

public class Konfigurasi {

    public static final String LINK = "http://192.168.1.54/pegawai/";
    public static final String URL_GET_ALL = LINK+"tampilSemuaPgw.php";
    public static final String URL_GET_DETAIL = LINK+"tampilPgw.php";
    public static final String URL_ADD = LINK+"tambahPgw.php";
    public static final String URL_UPDATE = LINK+"updatePgw.php";
    public static final String URL_DELETE = LINK +"hapusPgw.php";

    // data json berisi key dan value yang ada di browser
    public static final String KEY_PGW_ID = "id";
    public static final String KEY_PGW_NAMA = "name";
    public static final String KEY_PGW_JABATAN = "desg";
    public static final String KEY_PGW_GAJI = "salary";

    //flag JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAMA = "name";
    public static final String TAG_JSON_JABATAN = "desg";
    public static final String TAG_JSON_GAJI = "salary";

    //variabel ID PEGAWAI

    public static final String PGW_ID = "emp_id";
}
