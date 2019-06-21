package br.rmginner.dto.auctioning;

import java.util.List;

public class AuctioneerDto {

    private String cpf;

    private String name;

    private List<PhoneDto> phoneDtoList;

    private String email;

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

    public List<PhoneDto> getPhoneDtoList() {
        return phoneDtoList;
    }

    public void setPhoneDtoList(List<PhoneDto> phoneDtoList) {
        this.phoneDtoList = phoneDtoList;
    }

    public String getEmail() {
        return email;
    }

}
