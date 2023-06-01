package sg.edu.rp.c346.id22022096.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;

    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;
    EditText selectindex;
    Button remove;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonadditem);
        lvColour = findViewById(R.id.listviewcolour);
        selectindex = findViewById(R.id.editTextposition);
        remove = findViewById(R.id.buttonremove);
        update = findViewById(R.id.buttonupdate);

        alColour = new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColour);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addedColour = etElement.getText().toString();
                String index = selectindex.getText().toString();
                int indexno=Integer.parseInt(index);

                alColour.add(indexno,addedColour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String colour = alColour.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String index = selectindex.getText().toString();
                int indexno=Integer.parseInt(index);

                alColour.remove(indexno);
                aaColour.notifyDataSetChanged();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateColour = etElement.getText().toString();
                String index = selectindex.getText().toString();
                int indexno=Integer.parseInt(index);

                alColour.set(indexno,updateColour);
                aaColour.notifyDataSetChanged();

            }
        });

    }
}