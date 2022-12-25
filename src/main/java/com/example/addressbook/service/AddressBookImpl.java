package com.example.addressbook.service;
import com.example.addressbook.DTO.AddressDTO;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AddressBookImpl implements IAddressBook{
    @Autowired
    private AddressRepo addressRepo;

    private List<AddressBook> addData = new ArrayList<>();
    @Override
    public List<AddressBook> getAddressBookData() {
        List<AddressBook> addData = addressRepo.findAll();
        return addData;
    }
    @Override
    public AddressBook getAddressBookDataById(int personId) {
      Optional<AddressBook> addData = addressRepo.findById(personId);
      if(addData.isPresent()){
          return addData.get();
      }else{
          throw new AddressBookException("Id Not Found");
      }
    }
    @Override
    public AddressBook createAddressBookData(AddressDTO addressDTO) {
        AddressBook addData = new AddressBook(addressDTO);
        addressRepo.save(addData);
        return addData;
    }
    @Override
    public AddressBook updateAddressBookById(int personId, AddressDTO addressDTO) {
      AddressBook addData = new AddressBook(personId, addressDTO);
      addressRepo.findById(personId);
      return addData;
    }
    @Override
    public AddressBook deleteById(int personId) {
        Optional<AddressBook> addData = addressRepo.findById(personId);
      if(addData.isPresent()) {
          addressRepo.deleteById(personId);
          return addData.get();
      }else{
          throw new AddressBookException("Id Not Found");
      }
    }

    @Override
    public AddressBook findByEmail(String email) {
        AddressBook addData = addressRepo.findByEmail(email);
        return addData;
    }
}
