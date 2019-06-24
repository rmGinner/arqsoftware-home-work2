package br.rmginner.dao.auctioning.bidding.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.person.PhoneDao;
import br.rmginner.dao.auctioning.bidding.BidderDao;
import br.rmginner.model.auctioning.bidding.Bidder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class BidderDaoImpl extends AbstractDao implements BidderDao {

    @Autowired
    private PhoneDao phoneDao;

    public Bidder findByCpf(String cpf) {
        Bidder bidder = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM bidder WHERE cpf = ?");
                 var ps2 = conn.prepareStatement("SELECT * FROM person WHERE cpf = ?")) {
                ps.setString(1, cpf);
                ps2.setString(1, cpf);

                try (var rs = ps.executeQuery()) {
                    try (var rs2 = ps2.executeQuery()) {
                        if (rs.next()) {
                            bidder = new Bidder(
                                    rs.getString("cpf")
                            );

                            bidder.setEmail(rs2.getString("email"));
                            bidder.setName(rs2.getString("name"));
                            bidder.setPhones(phoneDao.findByPersonCpf(bidder.getCpf()));
                        }
                    } catch (SQLException e) {

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

        return bidder;
    }

}
