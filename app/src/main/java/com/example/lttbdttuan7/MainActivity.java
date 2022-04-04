package com.example.lttbdttuan7;

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
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    DataUser dataUser;
    Button btnAdd, btnRemove, btnCancel;
    EditText edtName;
    ListView lvName;
    ArrayList list = new ArrayList();
    ArrayList idList;
    ArrayAdapter    adapter;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idList = new ArrayList();

        dataUser = new DataUser(this, "userDbsqlite.sqlite", null, 1);

        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnCancel = findViewById(R.id.btnCancel);
        edtName = findViewById(R.id.edtName);
        lvName = findViewById(R.id.lvName);

        list = getAllName();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        lvName.setAdapter(adapter);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dataUser.addUser(new User(edtName.getText().toString()));
//                getAllName();
//                adapter.notifyDataSetChanged();
//            }
//        });

//        btnRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dataUser.removeUser((int)idList.get(index));
//                getAllName();
//                adapter.notifyDataSetChanged();
//                Toast.makeText(MainActivity.this,
//                        "Succesful", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                index =i;
//            }
//        });


    }

    public ArrayList getAllName() {
        list.clear();
        for (Iterator iterator = dataUser.getAllUser().iterator(); iterator.hasNext(); ) {
            User user =(User) iterator.next();
            list.add(user.getName());
//            idList.add(user.getId());
        }
        return list;
    }
}