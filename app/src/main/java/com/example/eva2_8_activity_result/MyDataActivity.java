package com.example.eva2_8_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyDataActivity extends AppCompatActivity implements ListView.OnItemClickListener, View.OnClickListener{
ListView lstVwRest;
Button button;
String[] rest={"Dominos","Pizzas Lalin","Wing Stop","Buffalucas","McDonalds","Burger King","Carls Jr","Wendys"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        lstVwRest = findViewById(R.id.lstVwRest);
        lstVwRest.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rest));
        lstVwRest.setOnItemClickListener(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent inDatos = new Intent();
        inDatos.putExtra("aaaa",rest[position]);
        setResult(Activity.RESULT_OK, inDatos);
        finish();

        Toast.makeText(this,rest[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
    setResult(Activity.RESULT_CANCELED);
    finish();
    }
}
