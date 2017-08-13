package com.example.kimhun.chattingtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListner;
    private ArrayAdapter<String> mAdapter;
    private ListView mListView;
    private EditText mEditMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        initFirebaseDatabase();
    }

    private void initviews(){
        mListView = (ListView) findViewById(R.id.list_message);
        mAdapter = new ChatAdapter(this, R.layout.listitem_chat);
        mListView.setAdapter(mAdapter);
        mEditMessage = (EditText) findViewById(R.id.edit_message);
        findViewById(R.id.btn_send).setOncClcikListener(this);
    }

    private void initFirebaseDatabase(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("message");
        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String message = dataSnapshot.getValue(String.class);
                mAdapter.add(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                mAdapter.remove(message);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildEventListner);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mDatabaseReference.removeEventListener(mChildEventListner);
    }

    @Override
    public void onClick(View view) {
        String message = mEditMessage.getText().toString();
        if(!TextUtils.isEmpty(message)){
            mEditMessage.setText("");
            mDatabaseReference.push().setValue(message);
        }
    }
}
