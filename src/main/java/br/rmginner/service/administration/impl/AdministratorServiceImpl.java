package br.rmginner.service.administration.impl;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.service.administration.AdministratorService;
import br.rmginner.service.auctioning.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AuctionService auctionService;

    @Override
    public List<AuctionDto> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

}
