package br.rmginner.dao.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.people.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneDao {

    List<Phone> findByIds(List<Long> id);

    List<Phone> findByPersonCpf(String personCpf);

}
