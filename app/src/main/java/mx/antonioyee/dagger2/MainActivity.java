package mx.antonioyee.dagger2;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import mx.antonioyee.dagger2.data.DataManager;
import mx.antonioyee.dagger2.data.model.User;
import mx.antonioyee.dagger2.di.component.ActivityComponent;
import mx.antonioyee.dagger2.di.component.DaggerActivityComponent;
import mx.antonioyee.dagger2.di.module.ActivityModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;
    private TextView txtUserInfo;
    private TextView txtAccessToken;

    public ActivityComponent getActivityComponent() {
        if ( activityComponent == null ) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }

        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        txtUserInfo = (TextView) findViewById(R.id.txtUserInfo);
        txtAccessToken = (TextView) findViewById(R.id.txtAccessToken);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("4362ljkn36lj5lc6bl25kj46bck4j5");

        String token = dataManager.getAccessToken();
        if ( token != null ) {
            txtAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = dataManager.getUser(1L);
            txtUserInfo.setText(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
