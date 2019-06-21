package br.rmginner.api.operations;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.service.auctioning.bidding.BidderService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BidderApi {

	private BidderService bidderService;

	public ResponseEntity<List<BidDto>> subscribeBid(BidDto bidDto) {
		return null;
	}

	public ResponseEntity<List<BidDto>> getSubscribedBids() {
		return null;
	}

}
