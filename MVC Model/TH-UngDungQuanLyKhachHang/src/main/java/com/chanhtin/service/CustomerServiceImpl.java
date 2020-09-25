package com.chanhtin.service;

import com.chanhtin.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static final Map<Integer,Customer> customerMap=new HashMap<>();
    public static int count=6;
    static {
        customerMap.put(1, new Customer(1, "Duong Do Nguyen", "0123456789",
                "duongdonguyen96@gmail.com","5/8/1985","Nu","Hanoi"));
        customerMap.put(2, new Customer(2, "Vo Long", "0321456987",
                "longvo95@gmail.com", "17/8/1997", "Nu",
                "25 Nguyen duy Trinh, Hue"));
        customerMap.put(3, new Customer(3, "Le Quang Hiep", "0147852369",
                "hieple94@gmail.com", "17/8/1999", "Nam",
                "57 Nguyen Hue, Hue"));
        customerMap.put(4, new Customer(4, "Do Chanh Tin", "0966257540",
                "dochanhtin07041995@gmail.com", "17/8/1995", "Nam",
                "30 Ha Noi, Hue"));
        customerMap.put(5, new Customer(5, "Nguyen Van Huong", "0325874169",
                "huongnguyenvan89@gmail.com", "17/8/1995", "Nam",
                "30 Hai Ba Trung, Hue"));
        customerMap.put(6, new Customer(6, "Le Tan Phuc", "0658741236",
                "letanphuc95@gmail.com", "17/8/1995", "Nam",
                "30 Ba Trieu, Hue"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        ++count;
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        if(customerMap.containsKey(id)){
            return customerMap.get(id);
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
