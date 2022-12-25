package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressBook,Integer> {
  @Query(value = "select * from address_book,email where person_id = id and email=:email",nativeQuery = true)
  AddressBook findByEmail(String email);
}
