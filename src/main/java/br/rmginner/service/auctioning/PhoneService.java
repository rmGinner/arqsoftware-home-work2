package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.model.people.Auctioneer;
import br.rmginner.model.people.Phone;

import java.util.List;

public interface PhoneService {

    List<PhoneDto> findPhonesByIds(List<Long> phoneIds);

}
