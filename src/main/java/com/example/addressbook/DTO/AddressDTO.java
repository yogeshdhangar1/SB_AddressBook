package com.example.addressbook.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
public class AddressDTO {
    @NotEmpty(message = "Please enter Your Full Name")
    @Pattern(regexp ="^[A-Z]{1}[a-z]{2,}\\s{0,}$",message = "please Enter Valid Name")
    private String fullName;
    @NotEmpty(message = "Please Enter Your Address")
    private  String address;
    @NotEmpty(message = "Please Enter Your City")
    private String city;
    @NotEmpty(message = "Please Enter Your State")
    private String state;
  @NotNull(message = "Please Enter Your Number")
    @Pattern(regexp = "^[0-9]{10}$",message = "mobile Number Must Be Ten Number")
    private String  phoneNum;
  @NotEmpty(message = "Please Enter Your Email")
  @Email
    private String email;
}
