package adi.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Combatant extends AppCompatActivity {

    private String title;
//    private ArrayList<String> title;
    private TextView titleView;
    private ArrayList<String> combatantList;
    private ListView listView;
    private EditText enterCombatant;
    private String newCombatant;
    private ArrayAdapter <String> combatantArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combatant);

//        SHIT FOR GETTING THE TITLE
        titleView = (TextView) findViewById(R.id.title);
        Intent intent = getIntent();
        title = intent.getStringExtra("COMBATANT");
        titleView.setText(title);

// COMBATANT LIST
        listView = (ListView) findViewById(R.id.combatants);
        combatantList = new ArrayList<>();
        combatantArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, combatantList);
        listView.setAdapter(combatantArrayAdapter);



//        MAYBE MAKE ITEMS STRIKETHROUGH ON CLICK???

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//            }
//        });




    }

    public void addCombatant(View v) {

        enterCombatant = (EditText) findViewById(R.id.enterCombatant);
        newCombatant = enterCombatant.getText().toString();

        if (enterCombatant.getText().toString() != "") {
            combatantList.add(newCombatant);
            combatantArrayAdapter.notifyDataSetChanged();
            enterCombatant.setText("");
        }
    }

}
