package com.ponyvillelive.pvlmobile;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.ponyvillelive.pvlmobile.net.NetModule;
import com.ponyvillelive.pvlmobile.service.ServiceModule;
import com.ponyvillelive.pvlmobile.ui.UiModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by berwyn on 16/08/14.
 */
@Module(
        injects = {
                PvlApp.class
        },
        includes = {
                UiModule.class,
                NetModule.class,
                ServiceModule.class
        },
        complete = false,
        library = true
)
public class PvlModule {
    private final PvlApp app;

    public PvlModule(PvlApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences("u2020", Context.MODE_PRIVATE);
    }
}
