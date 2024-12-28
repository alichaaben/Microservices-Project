package com.customers.customer.mapper;

import com.customers.customer.entity.Customer;
import com.customers.customer.dto.CustomerDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "name",target = "name")
    @Mapping(source = "email",target = "email")
    CustomerDto map(Customer entity);

    List<CustomerDto> map(List<Customer> entities);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    Customer unMap(CustomerDto dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    void updateEntityFromDto(@MappingTarget Customer entity, CustomerDto dto);
}
