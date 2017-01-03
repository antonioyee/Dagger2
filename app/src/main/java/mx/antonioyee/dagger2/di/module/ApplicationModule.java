package mx.antonioyee.dagger2.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import mx.antonioyee.dagger2.di.ApplicationContext;
import mx.antonioyee.dagger2.di.DatabaseInfo;

/**
 * Created by antonioyee on 31/12/16.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application app) {
        application = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}
