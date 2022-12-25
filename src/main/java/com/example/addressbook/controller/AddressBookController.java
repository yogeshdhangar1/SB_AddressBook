package com.example.addressbook.controller;
import com.example.addressbook.DTO.AddressDTO;
import com.example.addressbook.DTO.ResponseDTO;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.service.AddressBookImpl;
import com.example.addressbook.service.IAddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private IAddressBook service;
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBook> addData = service.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable int personId){
        AddressBook addData = service.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull By Id ",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressDTO addressDTO){
        AddressBook addData = service.createAddressBookData(addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("create AddressBook table successfully",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookById(
            @Valid @PathVariable("personId") int personId, @RequestBody AddressDTO addressDTO){
        AddressBook addData = service.updateAddressBookById(personId, addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update AddressBook table successfully",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteById( @PathVariable("personId")int personId){
        service.deleteById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Delete  AddressBook table successfully","Delete All data");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseDTO> findByEmail(@PathVariable String email){
        AddressBook addData = service.findByEmail(email);
        ResponseDTO responseDTO = new ResponseDTO("Find By EmailId",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
//    @GetMapping("/find/{city}")
//    public ResponseEntity<ResponseDTO> findByCity( @PathVariable String city){
//      List<AddressBook> addData = service.findByCity();
//      ResponseDTO responseDTO = new ResponseDTO("Find Id By City" , addData);
//      return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
//    }
}
