package com.manik.task.connection;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is a collection of all the request need to send to server,
 * for getting a specific request you need to pass certain parameter this will return a full request
 * object you just need to pass to your manager to controller
 *
 * @author Ravishankar
 * @version 1.0
 * @since 18-04-2017
 */

public class RequestProvider {
    private Context mContext;

    public RequestProvider(Context context) {
        mContext = context;
    }

    /**
     * @param listener Call back listener used to build the calling request for contactRequest
     * @return an object of contactRequest
     */
    public Request getContactRequest(RequestListener listener) {
        Map<String, String> params = new HashMap<String, String>();

        Request contactRequest = new Request.RequestBuilder(mContext, listener)
                .type(Request.Method.GET)
                .url(ApiProvider.getApiByTag(ApiTag.GET_CONTACT))
                .postParams(params)
                .tag(ApiTag.GET_CONTACT)
                .build();
        return contactRequest;

    }

}
