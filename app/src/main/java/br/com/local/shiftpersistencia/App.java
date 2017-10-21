package br.com.local.shiftpersistencia;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.hawk.Hawk;

/**
 * Created by logonrm on 21/10/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        Hawk.init(this).build();
    }
}
