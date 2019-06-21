package br.rmginner.dao.auctioning.impl;

import br.rmginner.dao.AbstractDao;
import br.rmginner.dao.auctioning.PhoneDao;
import br.rmginner.model.people.Phone;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PhoneDaoImpl extends AbstractDao implements PhoneDao {


    @Override
    public List<Phone> findByIds(List<Long> ids) {
        List<Phone> phoneList = new ArrayList<>();

        Phone phone = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM phone WHERE id in(?)")) {
                ps.setArray(1, conn.createArrayOf("INTEGER", ids.toArray()));

                try (var rs = ps.executeQuery()) {
                    if (rs.next()) {
                        phoneList.add(new Phone(
                                rs.getLong("id"),
                                rs.getInt("ddd"),
                                rs.getInt("number")
                        ));
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

        return phoneList;
    }

    @Override
    public List<Phone> findByPersonCpf(String personCpf) {
        List<Phone> phoneList = new ArrayList<>();

        Phone phone = null;

        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT * FROM phone WHERE person_cpf = ?")) {
                ps.setString(1, personCpf);

                try (var rs = ps.executeQuery()) {
                    if (rs.next()) {
                        phoneList.add(new Phone(
                                rs.getLong("id"),
                                rs.getInt("ddd"),
                                rs.getInt("number")
                        ));
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

        return phoneList;
    }
}
