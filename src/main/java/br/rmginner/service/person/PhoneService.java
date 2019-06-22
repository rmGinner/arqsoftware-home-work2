package br.rmginner.service.person;

import br.rmginner.dto.person.PhoneDto;

import java.util.List;

public interface PhoneService {

    List<PhoneDto> findPhonesByIds(List<Long> phoneIds);

}
