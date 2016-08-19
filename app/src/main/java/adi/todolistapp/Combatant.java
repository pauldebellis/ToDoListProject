package adi.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private ArrayAdapter<String> combatantArrayAdapter;
    private ArrayList<ArrayList<String>> encounterArray;
    private Button combatantButton;


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
        combatantArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combatantList);
        listView.setAdapter(combatantArrayAdapter);

        Button combatantButton = (Button)findViewById(R.id.combatantButton);
        combatantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCombatant(enterCombatant);
            }
        });



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
//            encounterArray.add(combatantList);
            combatantArrayAdapter.notifyDataSetChanged();
            enterCombatant.setText("");

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                combatantList.remove(info.position);
                combatantArrayAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);

        }


    }
}
