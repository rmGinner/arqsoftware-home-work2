package br.rmginner.service.administration.impl;

import br.rmginner.bo.administration.AdministratorBo;
import br.rmginner.dao.administration.AdministratorDao;
import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.administration.AdministratorService;
import br.rmginner.service.auctioning.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public List<AuctionDto> getAllAuctions(String adminCpf) throws BusinessValidationException {
        AdministratorBo.validateIfCpfIsOfAnAdmin(administratorDao.isAdministrator(adminCpf));

        return auctionService.getAllAuctions();
    }

}
