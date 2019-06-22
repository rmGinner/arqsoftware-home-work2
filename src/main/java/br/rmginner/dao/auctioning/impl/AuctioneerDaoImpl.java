package br.rmginner.dao.auctioning.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.auctioning.AuctioneerDao;
import br.rmginner.dao.person.PhoneDao;
import br.rmginner.model.auctioning.Auctioneer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AuctioneerDaoImpl extends AbstractDao implements AuctioneerDao {

    @Autowired
    private PhoneDao phoneDao;

    public Auctioneer findAuctioneerById(String cpf) {
        Auctioneer auctioneer = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM auctioneer WHERE cpf = ?");
                 var ps2 = conn.prepareStatement("SELECT * FROM person WHERE cpf = ?")) {
                ps.setString(1, cpf);
                ps2.setString(1, cpf);

                try (var rs = ps.executeQuery()) {
                    try (var rs2 = ps2.executeQuery()) {
                        if (rs.next() && rs2.next()) {
                            auctioneer = new Auctioneer(
                                    rs.getString("cpf")
                            );

                            auctioneer.setEmail(rs2.getString("email"));
                            auctioneer.setName(rs2.getString("name"));
                            auctioneer.setPhones(phoneDao.findByPersonCpf(auctioneer.getCpf()));
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auctioneer;
    }

}
