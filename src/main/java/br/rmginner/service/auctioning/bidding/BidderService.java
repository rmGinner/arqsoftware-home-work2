package br.rmginner.service.auctioning.bidding;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BidderService {

    public abstract boolean subscribeBid(BidDto bidDto);

    public abstract List<BidDto> getSubscribedBids(String token);

    Optional<BidderDto> findByCpf(String cpf);
}
