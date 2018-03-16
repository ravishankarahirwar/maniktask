package com.manik.task.callbacks;

import com.manik.task.model.Contact;

import java.util.List;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public interface ContactFetchListner {
    void onContactFetchedSuccessfully(Contact[] contacts);
    void onContactFatchedFailed(int errorCode);
}
