package com.example.kimhun.chattingtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Random;

//Model, View, Controller

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> mAdapter;
    private ListView mListView;
    private EditText mEditMessage;
    private Button mButton;

    private String userName;

    FirebaseManager firebaseManager = new FirebaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        firebaseManager.initFirebaseDatabase(mAdapter);
    }

    private void initviews(){

        mListView = (ListView) findViewById(R.id.list_message);
        mEditMessage = (EditText) findViewById(R.id.edit_message);
        mButton = (Button) findViewById(R.id.btn_send);

        userName = "user" + new Random().nextInt(10000);

        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);

        mListView.setAdapter(mAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData chatData = new ChatData(userName, mEditMessage.getText().toString());
                firebaseManager.pushData(chatData);
                mEditMessage.setText("");
            }
        });
    }

}
