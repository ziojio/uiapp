package demo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import demo.ui.activity.MainActivity;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2020/11/29
 * desc   : 重启应用
 */
public final class RestartActivity extends Activity {

    public static void start(Context context) {
        Intent intent = new Intent(context, RestartActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restart(this);
        finish();
    }

    public static void restart(Context context) {
        Intent intent;
        if (true) {
            // 如果是未登录的情况下跳转到闪屏页
            intent = new Intent(context, MainActivity.class);
        } else {
            // 如果是已登录的情况下跳转到首页
            intent = new Intent(context, MainActivity.class);
        }

        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}