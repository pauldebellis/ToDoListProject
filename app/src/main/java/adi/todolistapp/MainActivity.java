package adi.todolistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> encounterList;
    private ArrayAdapter<String> encountersArrayAdapter;
    private ListView listView;
    private EditText enterEncounter;
    private String newEncounter;
    private Button encounterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterEncounter = (EditText) findViewById(R.id.enterEncounter);
        newEncounter = enterEncounter.getText().toString();


        listView = (ListView) findViewById(R.id.encounters);

        encounterList = new ArrayList<>();

        encounterList.add("poop");

        encountersArrayAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, encounterList);
        listView.setAdapter(encountersArrayAdapter);

//        encounterButton.setOnClickListener();

    }

    public void addEncounter(View v) {
        encounterList.add(newEncounter);
        encountersArrayAdapter.notifyDataSetChanged();
    }

}
