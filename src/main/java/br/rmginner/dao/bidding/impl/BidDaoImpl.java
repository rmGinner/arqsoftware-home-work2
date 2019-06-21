package br.rmginner.dao.bidding.impl;

import br.rmginner.dao.bidding.BidDao;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.auction.Bid;
import br.rmginner.dao.AbstractDao;
import br.rmginner.model.people.Bidder;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BidDaoImpl extends AbstractDao implements BidDao {


    /**
     * @see br.rmginner.dao.bidding.BidDao#saveBidWithAuctionReference(br.rmginner.model.auction.Bid)
     */
    public void saveBidWithAuctionReference(Bid bid) {

    }


    /**
     * @see br.rmginner.dao.bidding.BidDao#getSubscribedBidsOfBidder(String)
     */
    public List<Bid> getSubscribedBidsOfBidder(String bidderCpf) {
        var bidList = new ArrayList<Bid>();

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM bid WHERE bidder_cpf = ?")) {
                ps.setString(1, bidderCpf);

                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        var bid = new Bid(
                                rs.getLong("id"),
                                new Auction(rs.getLong("auction_id")),
                                rs.getBigDecimal("price"),
                                new Bidder(rs.getString("bidder_cpf"))
                        );

                        bidList.add(bid);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bidList;
    }

    @Override
    public List<Bid> findByAuctionId(Long auctionId) {
        var bidList = new ArrayList<Bid>();

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM bid WHERE auction_id = ?")) {
                ps.setLong(1, auctionId);

                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        var bid = new Bid(
                                rs.getLong("id"),
                                new Auction(rs.getLong("auction_id")),
                                rs.getBigDecimal("price"),
                                new Bidder(rs.getString("bidder_cpf"))
                        );

                        bidList.add(bid);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bidList;
    }
}
