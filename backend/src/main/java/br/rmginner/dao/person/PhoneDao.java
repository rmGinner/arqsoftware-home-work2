package br.rmginner.dao.person;

import br.rmginner.model.people.Phone;

import java.util.List;

public interface PhoneDao {

    List<Phone> findByIds(List<Long> id);

    List<Phone> findByPersonCpf(String personCpf);

}
