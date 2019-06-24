package br.rmginner.factory.person;

import br.rmginner.dto.person.PhoneDto;
import br.rmginner.model.people.Phone;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PhoneDtoFactory {

    public static List<PhoneDto> createFrom(List<Phone> phoneList) {
        return CollectionUtils.isEmpty(phoneList) ?
                List.of() :
                phoneList.stream()
                        .map(PhoneDtoFactory::createFrom)
                        .collect(Collectors.toList());
    }

    public static PhoneDto createFrom(Phone phone) {
        return Objects.nonNull(phone) ? new PhoneDto(phone.getId(), phone.getDdd(), phone.getNumber()) : null;
    }
}
