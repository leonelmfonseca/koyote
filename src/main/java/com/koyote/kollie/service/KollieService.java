package com.koyote.kollie.service;

import com.koyote.kollie.model.KollieModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


public interface KollieService <T extends KollieModel>{

    List<T> fetchData(String search) throws GeneralSecurityException, IOException;
}
