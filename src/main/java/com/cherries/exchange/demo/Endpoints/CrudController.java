package com.cherries.exchange.demo.Endpoints;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CrudController<U,T> {
    public List<U> getAddresses();
    public U getAddresses(T id);
}
