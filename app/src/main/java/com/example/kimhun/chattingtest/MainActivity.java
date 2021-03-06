package com.example.kimhun.chattingtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Random;

//Model, View, Controller

public class MainActivity extends AppCompatActivity {

    private ListViewAdapter mAdapter;
    private ListView mListView;
    private EditText mEditMessage;
    private Button letterButton;
    private Button imageButton;

    private String userName;

    FirebaseManager firebaseManager = new FirebaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        firebaseManager.initFirebaseDatabase(mAdapter);
    }

    private void initViews(){

        mListView = (ListView) findViewById(R.id.list_message);
        mEditMessage = (EditText) findViewById(R.id.edit_message);
        letterButton = (Button) findViewById(R.id.btn_send);
        imageButton = (Button) findViewById(R.id.btn_image);

        userName = "user" + new Random().nextInt(10000);

        mAdapter = new ListViewAdapter();

        mListView.setAdapter(mAdapter);

        letterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Letter message = new Letter(userName, mEditMessage.getText().toString());
                firebaseManager.pushData(message);
                mEditMessage.setText("");
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

    }

}
