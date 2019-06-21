package br.rmginner.dao;

import br.rmginner.factory.dao.ConnectionFactory;

public abstract class AbstractDao {

    /**
     * Singleton
     */
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    protected ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

}
