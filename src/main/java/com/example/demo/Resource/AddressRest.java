package com.example.demo.Resource;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.service.Address.AddressService;
import com.example.demo.service.Address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressRest {
    @Autowired
    private IAddressService iAddressService;
    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> gerAll(){
        List<Address> addressList = iAddressService.getAll();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
