package examples.aaronhoskins.com.week1day4demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent() != null) {
            Intent dataIntent = getIntent();
            //getData
            //set up data to return
            setResult(234, dataIntent);
            finish();
        }
    }
}
