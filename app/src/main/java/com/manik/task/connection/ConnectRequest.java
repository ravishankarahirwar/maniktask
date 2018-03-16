package com.manik.task.connection;

import android.content.Context;

import java.util.Map;


/**
 * @author Ravishankar
 * @version 1.0
 * @since 14-04-2017
 */

public class ConnectRequest {
    protected Context mContext;
    protected String mRawData;
    protected Map<String, String> mPostParams;
    protected Map<String, String> mHeaderParams;
    protected RequestListener mConnectionListener;
}
