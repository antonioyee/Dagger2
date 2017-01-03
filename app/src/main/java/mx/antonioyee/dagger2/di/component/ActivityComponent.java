package mx.antonioyee.dagger2.di.component;

import dagger.Component;
import mx.antonioyee.dagger2.MainActivity;
import mx.antonioyee.dagger2.di.PerActivity;
import mx.antonioyee.dagger2.di.module.ActivityModule;

/**
 * Created by antonioyee on 31/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
