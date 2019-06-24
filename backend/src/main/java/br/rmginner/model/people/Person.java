package br.rmginner.model.people;

import java.util.List;

public abstract class Person {

    private String cpf;

    private String name;

    private List<Phone> phones;

    private String email;

    public Person() {

    }

    public Person(String cpf, String name, List<Phone> phones, String email) {
        this.cpf = cpf;
        this.name = name;
        this.phones = phones;
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
