package com.example.templateappandroid.view.listeners;


import com.example.templateappandroid.model.entity.ContactEntity;

/**
 * Created by emedinaa on 07/04/2015.
 */
public interface OnHomeListener {

    public void addContact(Object object);
    public void listContacts();
    public void selectedContact(ContactEntity contactEntity);
}
