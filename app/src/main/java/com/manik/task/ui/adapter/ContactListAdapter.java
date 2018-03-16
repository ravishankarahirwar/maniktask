package com.manik.task.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manik.task.R;
import com.manik.task.model.Contact;
import com.manik.task.ui.viewholders.ContactViewHolder;

import java.util.List;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    Contact[] contacts;

    public ContactListAdapter(Contact[] contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(itemView);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contacts[position];
        holder.mContactId.setText(contact.getId());
        holder.mContactName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }
}
