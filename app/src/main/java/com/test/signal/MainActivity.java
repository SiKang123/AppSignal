package com.test.signal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import signal.JNISignal;
import com.test.signature.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Signal_Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 从 JNI 层获取暗号，每一次请求都携带最新的暗号
         * */
        Log.i(TAG, "signal : " + JNISignal.getAppSignal(this));

        /**
         * 当前使用签名的hashCode，需要备份到服务端
         * */
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(
                    "tech.starwin.signature", PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            Log.i(TAG, "hashCode : " + sign.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
