package com.example.addressbook.service;

import com.example.addressbook.DTO.AddressDTO;
import com.example.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBook {
    List<AddressBook> getAddressBookData();
    AddressBook getAddressBookDataById(int personId);
    AddressBook createAddressBookData(AddressDTO addressDTO);
    AddressBook updateAddressBookById(int personId, AddressDTO addressDTO);

     AddressBook deleteById(int personId);

    AddressBook findByEmail(String email);

    //  List<AddressBook> findByCity();
}
