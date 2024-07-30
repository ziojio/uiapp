package androidz;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;


class AndroidzInitializer implements Initializer<AndroidzInitializer> {

    @NonNull
    @Override
    public AndroidzInitializer create(@NonNull Context context) {
        Androidz.initialize(context);
        return this;
    }

    @NonNull
    @Override
    public List<Class<? extends androidx.startup.Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}