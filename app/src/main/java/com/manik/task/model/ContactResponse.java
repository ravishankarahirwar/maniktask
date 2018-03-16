package com.manik.task.model;

import com.manik.task.connection.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */

public class ContactResponse implements Response {
    Contact [] contacts = new Contact[]{};

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }
}
