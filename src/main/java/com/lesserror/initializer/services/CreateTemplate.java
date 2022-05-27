package com.lesserror.initializer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTemplate {

    @Autowired
    FrontedSelector frontedSelector;

    @Autowired
    BackendSelector backendSelector;

    @Autowired
    CombineZip combineZip;

    public void create(String frontend, String backend){
        frontedSelector.select(frontend);
        backendSelector.select(backend);
        combineZip.combine(frontend,backend);
    }
}
