package id.kiadzaky.individual_task.ui.detail_kelas;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    Context mContext;
    public WebAppInterface(Context c) {
        mContext = c;
    }
    @JavascriptInterface
    public void showToast(String toast) {
        System.exit(1);
    }
}
