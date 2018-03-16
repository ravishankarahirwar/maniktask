package com.manik.task.managers;

import android.content.Context;

import com.manik.task.callbacks.ContactFetchListner;
import com.manik.task.connection.ApiTag;
import com.manik.task.connection.RequestListener;
import com.manik.task.connection.RequestProvider;
import com.manik.task.connection.Response;
import com.manik.task.connection.RquestHandler;
import com.manik.task.managers.role.IContactManagerRole;
import com.manik.task.model.Contact;
import com.manik.task.model.ContactResponse;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ContactManager implements IContactManagerRole, RequestListener {

    private Context mContext;
    private RequestProvider mRequestProvider;
    private RquestHandler mRquestHandler;
    private ContactFetchListner mContactFetchListner;

    public ContactManager(Context context) {
        this.mContext = context;
        this.mRequestProvider = new RequestProvider(mContext);
        mRquestHandler = new RquestHandler(mContext);
    }

    @Override
    public void getAllContact(ContactFetchListner contactFetchListner) {
        mContactFetchListner = contactFetchListner;
        mRquestHandler.send(mRequestProvider.getContactRequest(this));
    }

    @Override
    public void onResponse(int responseResult, int apiTag, Response response) {
            if(apiTag == ApiTag.GET_CONTACT) {
                ContactResponse contactResponse = (ContactResponse)response;
                mContactFetchListner.onContactFetchedSuccessfully(contactResponse.getContacts());
            }
    }

    @Override
    public void onError(int responseResult, int apiTag, String message, Response response) {

    }
}
