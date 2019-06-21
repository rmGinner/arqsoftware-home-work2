package br.rmginner.dao.auctioning.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.auctioning.AuctionItemDao;
import br.rmginner.model.auction.AuctionItem;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AuctionItemDaoImpl extends AbstractDao implements AuctionItemDao {


    @Override
    public AuctionItem findById(Long auctionId) {
        AuctionItem auctionItem = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM auction_item WHERE id = ?")) {
                ps.setLong(1, auctionId);

                try (var rs = ps.executeQuery()) {
                    if (rs.next()) {
                        auctionItem = new AuctionItem(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")
                        );
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

        return auctionItem;
    }
}
