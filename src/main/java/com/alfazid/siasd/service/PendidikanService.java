package com.alfazid.siasd.service;

import com.alfazid.siasd.model.entity.Pendidikan;
import com.alfazid.siasd.repository.PendidikanRepository;
import com.alfazid.siasd.utilities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Optional;

/**
 * Created by cigist on 14/08/20.
 */

@Service
public class PendidikanService implements BaseService<Pendidikan> {
    private PendidikanRepository pendidikanRepository;

    private HttpServletRequest httpServletRequest;

    public PendidikanService(PendidikanRepository pendidikanRepository, HttpServletRequest httpServletRequest) {
        this.pendidikanRepository = pendidikanRepository;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void create(Pendidikan input) {
        Pendidikan pendidikan = Pendidikan.builder()	
        .idPendidikan(CommonUtil.generateUUID())
        .namaPendidikan(input.getNamaPendidikan())
        .active(input.getActive())
        .createdBy(httpServletRequest.getSession().getAttribute(SessionContext.USERNAME).toString())
        .createdAt(new Timestamp(System.currentTimeMillis()))
        .build();
        pendidikanRepository.save(pendidikan);
    }

    @Override
    public Page<Pendidikan> read(Pendidikan input, BasePagintaion basePagintaion, Pageable pageable) {
        String searchBy = basePagintaion.getSearchBy()==null?"":basePagintaion.getSearchBy();
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Pendidikan> records=null;
        if(searchBy.equals("idPendidikan")){
            records= pendidikanRepository.findByIdPendidikanAndActive(basePagintaion.getSearchValue(), Constants.ACTIVE, page);
        }else if(searchBy.equals("namaPendidikan")){
            records= pendidikanRepository.findByNamaPendidikanContainingAndActive(basePagintaion.getSearchValue(), Constants.ACTIVE, page);
        }else if(searchBy.equals("active")){
            records= pendidikanRepository.findByActive(basePagintaion.getSearchValue(),page);
        }else{
            records= pendidikanRepository.findByActive(Constants.ACTIVE,page);
        }
        return records;
    }

    @Override
    public void update(Pendidikan input) {
        Optional<Pendidikan> optional = pendidikanRepository.findById(input.getIdPendidikan());
        if(optional.isPresent()){
            Pendidikan pendidikan = optional.get();
            pendidikan.setNamaPendidikan(input.getNamaPendidikan());
            pendidikan.setActive(input.getActive());
            pendidikan.setUpdatedBy(httpServletRequest.getSession().getAttribute(SessionContext.USERNAME).toString());
            pendidikan.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            pendidikanRepository.save(pendidikan);
        }
    }

    @Override
    public void delete(String id) {
        Optional<Pendidikan> optional = pendidikanRepository.findById(id);
        if(optional.isPresent()){
            Pendidikan pendidikan = optional.get();
            pendidikan.setActive(Constants.NON_ACTIVE);
            pendidikanRepository.save(pendidikan);
        }

    }

    @Override
    public Optional<Pendidikan> findById(String id) {
        return pendidikanRepository.findById(id);
    }
}
