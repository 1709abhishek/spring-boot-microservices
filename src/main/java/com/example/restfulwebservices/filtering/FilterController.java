package com.example.restfulwebservices.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filter")
    public MappingJacksonValue getAllFilters(){
        Fields field  = new Fields("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(field);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filter-list")
    public List<Fields> getAllFilterList(){
        return Arrays.asList(new Fields("value1","value2","value3"),new Fields("value4","value5","value6"));
    }
}
