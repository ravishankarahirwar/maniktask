package com.manik.task.connection;

import com.android.volley.DefaultRetryPolicy;
/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ProviderUtils {
    private static final int API_RETRY_TIME = 60000;
    public static final String BODY_CONTENT_TYPE = "application/json";

public static DefaultRetryPolicy getRetryPolicy() {
    return new DefaultRetryPolicy(API_RETRY_TIME,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
}
}

