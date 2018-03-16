package com.manik.task.connection;

import android.content.ContentValues;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ParamsProvider {

    public static Map<String, String> getHeaderParams() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        return headers;
    }
}
