package com.manik.task.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.manik.task.R;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public TextView mContactId;
    public TextView mContactName;

    public ContactViewHolder(View itemView) {
        super(itemView);
        mContactId = itemView.findViewById(R.id.contact_id);
        mContactName = itemView.findViewById(R.id.contact_name);
    }
}
