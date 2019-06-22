package br.rmginner.dao.administration;

import br.rmginner.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Repository
public class AdministratorDaoImpl extends AbstractDao implements AdministratorDao {

    @Override
    public boolean isAdministrator(String cpf) {
        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT 1 FROM administrator WHERE cpf = ?")) {
                ps.setString(1, cpf);

                try (var rs = ps.executeQuery()) {
                    return rs.next();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
