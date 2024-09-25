package com.koyote.gather.service;

import com.koyote.gather.model.GatherModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


public interface GatherService <T extends GatherModel>{

    List<T> fetchData(String search) throws GeneralSecurityException, IOException;
}
