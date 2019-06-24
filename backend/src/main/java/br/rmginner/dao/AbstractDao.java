package br.rmginner.dao;

import br.rmginner.factory.dao.ConnectionFactory;

import java.sql.SQLException;

public abstract class AbstractDao {

    /**
     * Singleton
     */
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    protected ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    protected Long getLastInsertedId() {
        try (var conn = getConnectionFactory().getConnection()) {
            try (var ps = conn.prepareStatement("SELECT LAST_INSERT_ID() as id")) {
                try (var rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getLong("id");
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

        return null;
    }

}
