package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.exception.ModelNotFoundException;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.service.IGenericService;

import java.util.List;

public abstract class GenericService<T, ID> implements IGenericService<T, ID> {
    protected abstract IGenericRepository<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }


    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        //return getRepo().findById(id).orElse(null);
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
