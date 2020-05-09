package com.cherries.exchange.demo.Endpoints;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CrudController<U,T> {
    public List<U> getObjects();
    public U getObject(T id);
}
