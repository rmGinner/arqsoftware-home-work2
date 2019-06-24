package br.rmginner.model.authentication;

import br.rmginner.model.auctioning.AuctionItem;
import br.rmginner.model.auctioning.Auctioneer;
import br.rmginner.model.auctioning.bidding.Bid;

import java.util.List;

public class Authentication {

    private String cpf;

    private String password;

    public Authentication(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
