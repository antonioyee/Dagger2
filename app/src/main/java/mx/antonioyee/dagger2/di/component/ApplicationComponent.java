package mx.antonioyee.dagger2.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import mx.antonioyee.dagger2.DemoApplication;
import mx.antonioyee.dagger2.data.DataManager;
import mx.antonioyee.dagger2.data.DbHelper;
import mx.antonioyee.dagger2.data.SharedPrefsHelper;
import mx.antonioyee.dagger2.di.ApplicationContext;
import mx.antonioyee.dagger2.di.module.ApplicationModule;

/**
 * Created by antonioyee on 31/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
