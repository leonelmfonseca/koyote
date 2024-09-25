package com.koyote.gather.service;

import com.koyote.gather.model.GatherModel;

public interface ServiceFactory<T extends GatherModel> {
    GatherService<T> createService();
}
