package br.rmginner.dao.auctioning.bidding.impl;

import br.rmginner.dao.auctioning.bidding.BidDao;
import br.rmginner.model.auctioning.Auction;
import br.rmginner.model.auctioning.bidding.Bid;
import br.rmginner.dao.AbstractDao;
import br.rmginner.model.auctioning.bidding.Bidder;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BidDaoImpl extends AbstractDao implements BidDao {


    @Override
    public boolean saveBidWithAuctionReference(Bid bid) {
        try (var conn = getConnectionFactory().getConnection()) {
            conn.setAutoCommit(false);

            try (var ps = conn.prepareStatement("INSERT INTO bid(auction_id, price, bidder_cpf) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setLong(1, bid.getAuction().getId());
                ps.setBigDecimal(2, bid.getPrice());
                ps.setString(3, bid.getBidder().getCpf());

                if (ps.executeUpdate() > 0) {
                    conn.commit();

                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * @see br.rmginner.dao.auctioning.bidding.BidDao#getSubscribedBidsOfBidder(String)
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
