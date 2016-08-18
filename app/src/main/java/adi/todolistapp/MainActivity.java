package adi.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> encounterList;
    private ArrayList<String> combatantList;
    private ArrayAdapter<String> encountersArrayAdapter;
    private ArrayAdapter<String> combatantsArrayAdapter;
    private ListView listView;
    private ListView listView2;
    private EditText enterEncounter;
    private String newEncounter;
    private Button encounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.encounters);
//        listView2 = (ListView) findViewById(R.id.combatantView);

        encounterList = new ArrayList<>();
        combatantList = new ArrayList<>();

        encounterList.add("poop");

        encountersArrayAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, encounterList);
        listView.setAdapter(encountersArrayAdapter);

//        combatantsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combatantList);
//        combatantList.setAdapter(combatantsArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(view.getContext(), Combatant.class);
                startActivity(intent);
        }
        });
    }

    public void addEncounter(View v) {

        enterEncounter = (EditText) findViewById(R.id.enterEncounter);
        newEncounter = enterEncounter.getText().toString();

        if (enterEncounter.getText().toString() != "") {
            encounterList.add(newEncounter);
            encountersArrayAdapter.notifyDataSetChanged();

            enterEncounter.setText("");
        }
    }

//    public void openEncounter(View v) {
//        Intent intent = new Intent(this, Combatant.class);
//        ListView combatants = (ListView) findViewById(R.id.combatantView);
//        startActivity(intent);
//    }
}
