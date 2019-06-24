package br.rmginner.service.person.impl;

import br.rmginner.dao.person.PhoneDao;
import br.rmginner.dto.person.PhoneDto;
import br.rmginner.service.person.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    @Override
    public List<PhoneDto> findPhonesByIds(List<Long> phoneIds) {
        return phoneDao.findByIds(phoneIds)
                .stream()
                .map(phone -> new PhoneDto(phone.getId(), phone.getDdd(), phone.getNumber()))
                .collect(Collectors.toList());
    }
}
