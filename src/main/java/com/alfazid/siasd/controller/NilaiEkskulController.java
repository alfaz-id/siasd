package com.alfazid.siasd.controller;

import com.alfazid.siasd.repository.NilaiEkskulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(name = "/nilaiekskul")
public class NilaiEkskulController {
    @Autowired
    private NilaiEkskulRepository nilaiEkskulRepository;
}
