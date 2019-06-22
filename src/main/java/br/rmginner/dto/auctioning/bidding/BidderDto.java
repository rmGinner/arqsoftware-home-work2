package br.rmginner.dto.auctioning.bidding;

import br.rmginner.dto.person.PhoneDto;

import java.util.List;

public class BidderDto {

    private String cpf;

    private String name;

    private List<PhoneDto> phoneDtoList;

    private String email;

    public BidderDto(String cpf) {
        this.cpf = cpf;
    }

    public BidderDto(String cpf, String name, List<PhoneDto> phoneDtoList, String email) {
        this.cpf = cpf;
        this.name = name;
        this.phoneDtoList = phoneDtoList;
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

    public List<PhoneDto> getPhoneDtoList() {
        return phoneDtoList;
    }

    public void setPhoneDtoList(List<PhoneDto> phoneDtoList) {
        this.phoneDtoList = phoneDtoList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
