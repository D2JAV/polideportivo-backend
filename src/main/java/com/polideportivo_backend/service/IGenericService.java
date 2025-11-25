package com.polideportivo_backend.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T t);
    T update(ID id, T t);  // CAMBIÉ ESTA LÍNEA: (T t, ID id) → (ID id, T t)
    void deleteById(ID id);
}