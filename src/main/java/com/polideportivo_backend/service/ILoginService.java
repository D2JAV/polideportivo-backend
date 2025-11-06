package com.polideportivo_backend.service;

import com.polideportivo_backend.dto.LoginDTO;
import com.polideportivo_backend.model.Login;
import jakarta.validation.Valid;

public interface ILoginService extends IGenericService<Login, Integer> {
    Login validAndSave(Login login);
    // Métodos específicos como en IPatientService

}