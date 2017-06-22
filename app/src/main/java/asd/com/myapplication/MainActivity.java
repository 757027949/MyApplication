package asd.com.myapplication;

import android.icu.util.Measure;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import asd.com.anim.Rotate3DAnimation;
import asd.com.hint.LoadingAndRetryManager;
import asd.com.hint.OnLoadingAndRetryListener;

public class MainActivity extends AppCompatActivity {
    TextView hello;

    LoadingAndRetryManager loadingAndRetryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = (TextView) findViewById(R.id.hello);
        Rotate3DAnimation rotate3DAnimation = new Rotate3DAnimation(0, 30, 0, 0, 0, true);
        rotate3DAnimation.setFillAfter(true);
        rotate3DAnimation.setDuration(3000);
        hello.setAnimation(rotate3DAnimation);
        rotate3DAnimation.start();

//        loadingAndRetryManager = LoadingAndRetryManager.generate(findViewById(R.id.hello), new OnLoadingAndRetryListener() {
//            @Override
//            public void setRetryEvent(View retryView) {
//                Log.e("TAG", "asdlfjs....");
//            }
//        });
//
//        loadingAndRetryManager.showEmpty();
    }
}
