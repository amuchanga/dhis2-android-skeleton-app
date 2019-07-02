package com.example.android.androidskeletonapp.ui.splash;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.androidskeletonapp.R;
import com.example.android.androidskeletonapp.data.Sdk;

import org.hisp.dhis.android.core.D2;
import org.hisp.dhis.android.core.d2manager.D2Configuration;
import org.hisp.dhis.android.core.d2manager.D2Manager;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        disposable =
                instantiateD2()
                .doOnSuccess(d2 -> {

                    Toast.makeText(this,"Sucesso",Toast.LENGTH_LONG).show();


                    }
                ).doOnError(throwable -> {
                    Toast.makeText(this,"Erro",Toast.LENGTH_LONG).show();
                })
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private Single<D2> instantiateD2() {
        // TODO Instantiate d2
      D2Configuration configuration= Sdk.getD2Configuration(this);

        Single<D2> d2Single = D2Manager.setUp(configuration)
                .andThen(D2Manager.setServerUrl(this.getString(R.string.auto_fill_url)))
                .andThen(D2Manager.instantiateD2());

        return d2Single;
    }
}