package com.manik.task.managers.role;

import com.manik.task.callbacks.ContactFetchListner;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public interface IContactManagerRole {
    void getAllContact(ContactFetchListner contactFetchListner);
}
