package com.manik.task.connection;



/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */
public class ApiProvider {

    public static String getApiByTag(int apiTag) {
        String url;

        switch (apiTag) {

            case ApiTag.GET_CONTACT: // 1
                url = "https://s3.amazonaws.com/pulse-ugc/contacts.json";
                break;
            default:
                return null;
        }
        return url;
    }
}

