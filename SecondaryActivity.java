package com.example.carres;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.os.Bundle;
public class SecondaryActivity extends Activity {
    ListView listView;

    TextView selectC;

    int month;
    int day;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.list);
        selectC=(TextView)findViewById(R.id.textView3);

        final DatePicker datePicker=(DatePicker) findViewById(R.id.datePicker);
        Button button=(Button) findViewById(R.id.button);
        listView.setVisibility(View.INVISIBLE);
        selectC.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month=datePicker.getMonth();
                day=datePicker.getDayOfMonth();
                year=datePicker.getYear();
                listView.setVisibility(View.VISIBLE);
                selectC.setVisibility(View.VISIBLE);
            }

        });



        String[] values = new String[] { "Opel Astra","Volkswagen Passat","Volkswagen Golf"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition     = position;


                String  itemValue    = (String) listView.getItemAtPosition(position);

                listView.setVisibility(View.INVISIBLE);
                selectC.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),
                        "You reserved the " + itemValue +" for " + day +"."+(month+1)+"."+year, Toast.LENGTH_LONG)
                        .show();

            }

        });
    }
}
