package mx.antonioyee.dagger2;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import mx.antonioyee.dagger2.data.DataManager;
import mx.antonioyee.dagger2.di.component.ApplicationComponent;
import mx.antonioyee.dagger2.di.component.DaggerApplicationComponent;
import mx.antonioyee.dagger2.di.module.ApplicationModule;

/**
 * Created by antonioyee on 31/12/16.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
