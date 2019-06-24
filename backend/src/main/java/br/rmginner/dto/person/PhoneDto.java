package br.rmginner.dto.person;

public class PhoneDto {

    private Long id;

    private Integer ddd;

    private Integer phoneNumber;

    public PhoneDto(Long id, Integer ddd, Integer phoneNumber) {
        this.id = id;
        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
    }

    public PhoneDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "(" +
                ddd +
                ")" +
                " " +
                phoneNumber;
    }
}
