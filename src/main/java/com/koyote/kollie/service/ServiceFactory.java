package com.koyote.kollie.service;

import com.koyote.kollie.model.KollieModel;

public interface ServiceFactory<T extends KollieModel> {
    KollieService<T> createService();
}
