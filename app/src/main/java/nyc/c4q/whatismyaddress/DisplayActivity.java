package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private TextView displayText01;
    private TextView displayText02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent displayIntent = getIntent();
        String intentExtra = intentExtra = displayIntent.getStringExtra("VLSTR");

        displayText01 = (TextView) findViewById(R.id.display_textview01);
        displayText02 = (TextView) findViewById(R.id.display_textview02);

        displayText01.setText(intentExtra);
        displayText02.setText(intentExtra.length() + "");
    }
}
