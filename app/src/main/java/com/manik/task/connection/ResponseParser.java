package com.manik.task.connection;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.manik.task.model.Contact;
import com.manik.task.model.ContactResponse;
import com.manik.task.utils.Logger;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 17-04-2017
 */

public class ResponseParser {

    private int mApiTag;
    private RequestListener mConnectionListener;

    public  void parseJson(String data, Request request) {
        mApiTag = request.getTag();
        mConnectionListener = request.getConnectionListener();
        try {
            Gson gson = new Gson();
                Response response = getResponseObject(data, gson);
                Logger.v("parse json object: " + response);
            mConnectionListener.onResponse(RequestListener.RESPONSE_OK, mApiTag, response);

        } catch (JsonSyntaxException eJsonSyntaxException) {
            eJsonSyntaxException.printStackTrace();
            Logger.v("Exception JsonSyntaxException= " + eJsonSyntaxException.getMessage());
        }
    }

    private Response getResponseObject(String jsonData, Gson gson) {
        Response response = null;
        try {
            switch (this.mApiTag) {
                case ApiTag.GET_CONTACT: //1
                    Contact[] contacts = gson.fromJson(jsonData, Contact[].class);
                    ContactResponse contactResponse = new ContactResponse();
                    contactResponse.setContacts(contacts);
                    response = contactResponse;
                    break;
            }
        } catch (JsonSyntaxException eJsonSyntaxException) {
            eJsonSyntaxException.printStackTrace();
        } catch (Exception e) {
            Logger.v("Coming here in Exception in API TAg : " + this.mApiTag + "Exception message = " + e.getMessage());
        }
        return response;
    }
}
