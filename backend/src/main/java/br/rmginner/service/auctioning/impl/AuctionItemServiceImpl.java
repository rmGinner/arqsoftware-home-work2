package br.rmginner.service.auctioning.impl;

import br.rmginner.dao.auctioning.AuctionItemDao;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.factory.auctioning.dto.AuctionItemDtoFactory;
import br.rmginner.service.auctioning.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {

    @Autowired
    private AuctionItemDao auctionItemDao;

    @Override
    public AuctionItemDto findById(Long auctionId) {
        return Optional.of(auctionItemDao.findById(auctionId))
                .map(AuctionItemDtoFactory::createFrom)
                .orElse(null);
    }
}
