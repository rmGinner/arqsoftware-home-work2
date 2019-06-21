package br.rmginner.dao.auctioning.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.auctioning.AuctionDao;
import br.rmginner.enums.AuctionStatus;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.auction.AuctionItem;
import br.rmginner.model.people.Auctioneer;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuctionDaoImpl extends AbstractDao implements AuctionDao {


    /**
     * @see br.rmginner.dao.auctioning.AuctionDao#updateAction(br.rmginner.model.auction.Auction)
     */
    public boolean updateAction(Auction auction) {
        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("UPDATE auction SET owner_cpf = ? and status = ? and auction_item_id = ? WHERE id = ?")) {
                ps.setString(1, auction.getOwner().getCpf());
                ps.setString(2, auction.getStatus());
                ps.setLong(3, auction.getItem().getId());
                ps.setLong(4, auction.getId());

                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    @Override
    public boolean closeAuctionBy(Long auctionId, String auctioneerCpf) {
        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("UPDATE auction SET status = ? WHERE id = ? and owner_cpf = ?")) {
                ps.setString(1, AuctionStatus.CLOSED.getCode());
                ps.setLong(2, auctionId);
                ps.setString(3, auctioneerCpf);

                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @see br.rmginner.dao.auctioning.AuctionDao#findAuctionsByOwnerCpf(String ownerCpf)
     */
    public List<Auction> findAuctionsByOwnerCpf(String ownerCpf) {
        var auctionList = new ArrayList<Auction>();

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM auction WHERE owner_cpf = ?")) {
                ps.setString(1, ownerCpf);

                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        var auction = new Auction(
                                rs.getLong("id"),
                                new Auctioneer(rs.getString("owner_cpf")),
                                rs.getString("status"),
                                null,
                                new AuctionItem(rs.getLong("auction_item_id"))
                        );

                        auctionList.add(auction);
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

        return auctionList;
    }

    public boolean saveAuction(Auction auction) {
        try (var conn = getConnectionFactory().getConnection()) {
            conn.setAutoCommit(false);

            try (var ps = conn.prepareStatement("INSERT INTO auction_item(name, description) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, auction.getItem().getName());
                ps.setString(2, auction.getItem().getDescription());

                Integer savedItemId = ps.executeUpdate();

                if (savedItemId > 0) {
                    try (var ps2 = conn.prepareStatement("INSERT INTO auction(owner_cpf, status,auction_item_id) VALUES(?, ?,?)")) {
                        ps2.setString(1, auction.getOwner().getCpf());
                        ps2.setString(2, AuctionStatus.OPENED.getCode());
                        ps2.setLong(3, savedItemId);


                        var result = ps2.executeUpdate() > 0;

                        if (result) {
                            conn.commit();
                        }
                        conn.rollback();
                        return result;
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
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
     * @see br.rmginner.dao.auctioning.AuctionDao#findAllAuctions()
     */
    public List<Auction> findAllAuctions() {
        var auctionList = new ArrayList<Auction>();

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM auction")) {
                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        var auction = new Auction(
                                rs.getLong("id"),
                                new Auctioneer(rs.getString("owner_cpf")),
                                rs.getString("status"),
                                null,
                                new AuctionItem(rs.getLong("auction_item_id"))
                        );

                        auctionList.add(auction);
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

        return auctionList;
    }

}
