package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nyc.c4q.whatismyaddress.adapter.EmailAdapter;
import nyc.c4q.whatismyaddress.model.Email;

public class RecyclerActivity extends AppCompatActivity {
    private SharedPreferences recyclerPrefs;
    private ArrayList<Object> valueList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView emailRecyclerView = (RecyclerView) findViewById(R.id.emailRV);

        Intent intent = getIntent();
        String sharedPrefKey = intent.getStringExtra("sharedpref");
        recyclerPrefs = getApplicationContext().getSharedPreferences(sharedPrefKey, MODE_PRIVATE);

        Map<String, ?> allEntries = (Map<String, ?>) recyclerPrefs.getAll();
        for(Map.Entry<String, ?> entry : allEntries.entrySet()) {
            valueList.add(entry.getValue());

            List<Email> emails = new ArrayList<>();
            emails.add(new Email(valueList.toString()));

            EmailAdapter emailAdapter = new EmailAdapter(emails);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            emailRecyclerView.setAdapter(emailAdapter);
            emailRecyclerView.setLayoutManager(linearLayoutManager);

            Intent recyclerIntent = new Intent(RecyclerActivity.this, DisplayActivity.class);
            intent.putExtra("VLSTR", valueList.toString());
            startActivity(recyclerIntent);

        }

    }

}
