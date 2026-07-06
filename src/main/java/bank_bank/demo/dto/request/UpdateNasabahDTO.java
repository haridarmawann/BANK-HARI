package bank_bank.demo.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateNasabahDTO {

    private String address;
    private LocalDate birthDate;
    private String birthPlace;
    @Size(min = 10, max = 15, message = "Nomor Handphone Harus 10-15 Digit")
    @Pattern(regexp = "\\d+", message = "Nomor Handphone Harus Berupa Angka")
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
