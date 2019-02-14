package examples.aaronhoskins.com.week1day4demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnLongClickListener {
    TextView tvFirstName;
    TextView tvLastName;
    EditText etFirstName;
    EditText etLastName;
    Button btnDisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Old way was to cast and bind views
        tvFirstName = (TextView)findViewById(R.id.tvFirstNameDisplay);

        tvLastName = findViewById(R.id.tvLastNameDisplay);
        etFirstName = findViewById(R.id.etFirstNameInput);
        etLastName = findViewById(R.id.etLastNameInput);
        btnDisplayName = findViewById(R.id.btnSendName);
        etFirstName.addTextChangedListener(this);
        etLastName.addTextChangedListener(this);
        btnDisplayName.setOnLongClickListener(this);

        //btnDisplayName.setOnClickListener(this);
//        btnDisplayName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //take actions....
//            }
//        });
    }

    public void onButtonClickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnSendName:
                String fistName = etFirstName.getText() != null ? etFirstName.getText().toString() : "";
                String lastName = etLastName.getText().toString();
                tvFirstName.setText(fistName);
                tvLastName.setText(lastName);

                break;

            case R.id.btnClearName:
                tvFirstName.setText("");
                tvLastName.setText("");
                Intent secondActivityIntent = new Intent(this, SecondActivity.class);
                startActivity(secondActivityIntent);
                startActivityForResult(secondActivityIntent, 666);
                break;

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "LONG CLICK", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "String Length = " + s.toString().length(), Toast.LENGTH_LONG).show();
    }


//    @Override
//    public void onClick(View v) {
//
//    }
}
