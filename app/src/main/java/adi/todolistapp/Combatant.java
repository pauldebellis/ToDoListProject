package adi.todolistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Combatant extends AppCompatActivity {


    private ArrayList<String> title;
    private TextView titleView;
    private ArrayAdapter titleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combatant);

        titleView = (TextView) findViewById(R.id.title);

        title = new ArrayList<>();

        titleAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, title);

//TODO WHY DOESN'T IT LIKE SETADAPTER
        titleView.setAdapter(titleAdapter);
    }
}
