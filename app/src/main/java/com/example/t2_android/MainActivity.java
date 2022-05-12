package com.example.t2_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.t2_android.adapters.ContactAdapter;
import com.example.t2_android.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = getContacts();
        ContactAdapter adapter = new ContactAdapter(contacts);
        RecyclerView rv = findViewById(R.id.rvContacts);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }
    private List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1,"Luis Mendoza", "99999"));
        contacts.add(new Contact(2,"Renato Prieto", "111111"));
        contacts.add(new Contact(3,"Lucia Rodriguez", "22222"));
        contacts.add(new Contact(4,"Cristian Cardozo", "33333"));
        contacts.add(new Contact(5,"Juan Vilchez", "444444"));
        contacts.add(new Contact(6,"Samuel Prieto", "55555"));
        contacts.add(new Contact(7,"Sara Cabrera", "66666"));
        contacts.add(new Contact(8,"Camila Rodriguez", "15478"));
        contacts.add(new Contact(9,"Maria Medina", "12365"));
        contacts.add(new Contact(10,"Lorena Ortiz", "98654"));
        return contacts;
    }
}