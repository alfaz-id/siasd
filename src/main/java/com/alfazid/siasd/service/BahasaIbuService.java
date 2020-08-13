package com.alfazid.siasd.service;

import com.alfazid.siasd.model.entity.BahasaIbu;
import com.alfazid.siasd.repository.BahasaIbuRepository;
import com.alfazid.siasd.utilities.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Optional;

/**
 * Created by cigist on 23/07/20.
 */

@Service
@Log4j2
public class BahasaIbuService implements BaseService<BahasaIbu> {
    private BahasaIbuRepository bahasaIbuRepository;
    private HttpServletRequest httpServletRequest;

    public BahasaIbuService(BahasaIbuRepository bahasaIbuRepository, HttpServletRequest httpServletRequest) {
        this.bahasaIbuRepository = bahasaIbuRepository;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void create(BahasaIbu input) {
        BahasaIbu bahasaIbu = new BahasaIbu();
        bahasaIbu.setIdBahasaIbu(CommonUtil.generateUUID());
        bahasaIbu.setNamaBahasaIbu(input.getNamaBahasaIbu());
        bahasaIbu.setActive(Constants.ACTIVE);
        bahasaIbu.setCreatedBy(httpServletRequest.getSession().getAttribute(SessionContext.USERNAME).toString());
        bahasaIbu.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        bahasaIbuRepository.save(bahasaIbu);
    }

    @Override
    public Page<BahasaIbu> read(BahasaIbu input,BasePagintaion basePagintaion, Pageable pageable) {
        String searchBy = basePagintaion.getSearchBy()==null?"":basePagintaion.getSearchBy();
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<BahasaIbu> records=null;
        if(searchBy.equals("idBahasaIbu")){
           records= bahasaIbuRepository.findByIdBahasaIbuAndActive(basePagintaion.getSearchValue(), Constants.ACTIVE, page);
        }else if(searchBy.equals("namaBahasaIbu")){
           records= bahasaIbuRepository.findByNamaBahasaIbuContainingAndActive(basePagintaion.getSearchValue(), Constants.ACTIVE, page);
        }else if(searchBy.equals("active")){
           records= bahasaIbuRepository.findByActive(basePagintaion.getSearchValue(),page);
        }else{
           records= bahasaIbuRepository.findByActive(Constants.ACTIVE,page);
        }
        return records;
    }

    @Override
    public void update(BahasaIbu input) {
        Optional<BahasaIbu>optional = bahasaIbuRepository.findById(input.getIdBahasaIbu());
        if(optional.isPresent()){
            BahasaIbu bahasaIbu = optional.get();
            bahasaIbu.setNamaBahasaIbu(input.getNamaBahasaIbu());
            bahasaIbu.setActive(input.getActive());
            bahasaIbu.setUpdatedBy(httpServletRequest.getSession().getAttribute(SessionContext.USERNAME).toString());
            bahasaIbu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            bahasaIbuRepository.save(bahasaIbu);
        }
    }

    @Override
    public void delete(String id) {
        Optional<BahasaIbu>optional = bahasaIbuRepository.findById(id);
        if(optional.isPresent()){
            BahasaIbu bahasaIbu = optional.get();
            bahasaIbu.setActive(Constants.NON_ACTIVE);
            bahasaIbu.setUpdatedBy(httpServletRequest.getSession().getAttribute(SessionContext.USERNAME).toString());
            bahasaIbu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            bahasaIbuRepository.save(bahasaIbu);
        }
    }

    @Override
    public Optional<BahasaIbu> findById(String id) {
        return bahasaIbuRepository.findById(id);
    }
}
