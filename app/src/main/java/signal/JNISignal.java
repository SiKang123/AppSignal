package signal;

import android.content.Context;

/**
 * Created by SiKang on 2018/10/10.
 */
public class JNISignal {
    static {
        System.loadLibrary("signal");
    }

    public static String getAppSignal(Context context) {
        return getSignal(context);
    }

    public static native String getSignal(Context context);
}
