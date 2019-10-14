package com.alfazid.siasd.controller;

import com.alfazid.siasd.repository.NilaiMapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(value = "/nilaimapel")
public class NilaiMapelController {
    @Autowired
    private NilaiMapelRepository nilaiMapelRepository;
}
