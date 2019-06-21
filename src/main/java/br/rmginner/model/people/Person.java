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
        return null;
    }

    public void setCpf(String cpf) {

    }

    public String getName() {
        return null;
    }

    public void setName(String name) {

    }

    public List<Phone> getPhones() {
        return null;
    }

    public void setPhones(List<Phone> phone) {

    }

    public String getEmail() {
        return null;
    }

    public void setEmail(String email) {

    }

}
