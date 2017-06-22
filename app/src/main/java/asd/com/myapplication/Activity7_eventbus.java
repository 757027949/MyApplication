package asd.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Activity7_eventbus extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        EventBus.getDefault().register(this);

        text = (TextView) findViewById(R.id.text);
    }

    public void go(View view) {
        Intent intent = new Intent(this, Activity8_eventbus.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowText(EventBusTest test) {
        text.setText(test.getMes());
    }

    public static class EventBusTest {
        private String mes;

        public EventBusTest(String mes) {
            this.mes = mes;
        }

        public String getMes() {
            return mes;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }
    }

}