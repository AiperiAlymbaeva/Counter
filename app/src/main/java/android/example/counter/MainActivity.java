package android.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    Button count;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (TextView) findViewById(R.id.number_variable);
        count = (Button) findViewById(R.id.count_button);

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter <= 9999) {
                    counter++;
                    number.setText(String.format("%04d", counter));
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);


    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counter = savedInstanceState.getInt("counter");
        number.setText(String.format("%04d", counter));

    }


}