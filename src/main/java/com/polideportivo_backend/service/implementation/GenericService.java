package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.exception.ResourceNotFoundException;
import com.polideportivo_backend.service.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID> implements IGenericService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepo();

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepo().findById(id);
    }

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepo().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado con id: " + id));
        return getRepo().save(t);
    }

    @Override
    public void deleteById(ID id) {
        T entity = getRepo().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado con id: " + id));
        getRepo().delete(entity);
    }
}