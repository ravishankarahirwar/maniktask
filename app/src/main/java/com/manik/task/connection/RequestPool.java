package com.manik.task.connection;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */
public class RequestPool {
	private static RequestPool sInstance;
    private RequestQueue mRequestQueue;
    private static Context sContext;

    private RequestPool(Context context) {
        sContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequestPool getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RequestPool(context);
        }
        return sInstance;
    }

    public void cancellAllPreviousRequestWithSameTag(String tag){
        getRequestQueue().cancelAll(tag);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(sContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}

