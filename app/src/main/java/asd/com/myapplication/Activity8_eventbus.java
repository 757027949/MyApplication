package asd.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class Activity8_eventbus extends AppCompatActivity {


    EditText mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        mes = (EditText) findViewById(R.id.mes);
    }

    public void send(View view) {
        EventBus.getDefault().post(new Activity7_eventbus.EventBusTest(mes.getText().toString()));
        finish();
    }

}