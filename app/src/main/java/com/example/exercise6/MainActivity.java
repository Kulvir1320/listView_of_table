package com.example.exercise6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editText = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);
        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> tables = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tables);
        listView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tables.clear();
                String numb = editText.getText().toString();
//                tables.add(numb);
                for(int i = 1; i<=10; i++){
                    int value = Integer.parseInt(numb) * i;
                    tables.add(Integer.toString(value));
                }
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tables.remove(i);
                adapter.notifyDataSetChanged();
            }
        });

    }

}
