package com.example.t2_android.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t2_android.R;
import com.example.t2_android.entities.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<Contact> contacts;
    public ContactAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {
        Contact contact = contacts.get(position);
        TextView tvContactName = vh.itemView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = vh.itemView.findViewById(R.id.tvContactNumber);
        tvContactName.setText(contact.name);
        tvContactNumber.setText(contact.number);
        Button btnCall = vh.itemView.findViewById(R.id.btnCall);
        String tel = "tel:"+contact.number;
        String sms = "smsto:"+contact.number;
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL);
                intentcall.setData(Uri.parse(tel));
                view.getContext().startActivity(intentcall);
            }
        });
        Button btnSms = vh.itemView.findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriSms = Uri.parse(sms);
                Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uriSms);
                intentSMS.putExtra("sms_body", "Hola mundo");
                view.getContext().startActivity(intentSMS);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
