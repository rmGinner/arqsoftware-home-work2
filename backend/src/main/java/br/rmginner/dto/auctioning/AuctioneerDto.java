package br.rmginner.dto.auctioning;

import br.rmginner.dto.person.PhoneDto;

import java.util.List;

public class AuctioneerDto {

    private String cpf;

    private String name;

    private List<PhoneDto> phones;

    private String email;


    public AuctioneerDto(String cpf) {
        this.cpf = cpf;
    }

    public AuctioneerDto(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

}
