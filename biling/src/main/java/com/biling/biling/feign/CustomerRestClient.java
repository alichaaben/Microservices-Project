package com.biling.biling.feign;

import com.biling.biling.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    CustomerDto findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<CustomerDto> findCustomers();//==> kif tabda tista3mil fi @Repository fi repo donc tnajim traja7a fi list mais ken emmbeded twalil t3ayet lil pageModel mouch List
}
