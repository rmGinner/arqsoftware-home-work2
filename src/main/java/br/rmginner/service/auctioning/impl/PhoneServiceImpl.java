package br.rmginner.service.auctioning.impl;

import br.rmginner.dao.auctioning.PhoneDao;
import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.model.people.Phone;
import br.rmginner.service.auctioning.AuctionService;
import br.rmginner.service.auctioning.AuctioneerService;
import br.rmginner.service.auctioning.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    @Override
    public List<PhoneDto> findPhonesByIds(List<Long> phoneIds) {
        return phoneDao.findByIds(phoneIds)
                .stream()
                .map(phone -> new PhoneDto(phone.getId(), phone.getDdd(), phone.getNumber()))
                .collect(Collectors.toList());
    }
}
