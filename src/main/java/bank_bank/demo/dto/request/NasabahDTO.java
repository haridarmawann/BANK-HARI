package bank_bank.demo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class NasabahDTO {
    private String name;

    @NotBlank(message = "Nama Harus Diisi")
    private String fullName;

    private String address;
    private LocalDate birthDate;
    private String birthPlace;

    @NotBlank(message = "No KTP Harus Diisi")
    @Size(min = 16, max = 16, message = "No KTP Harus 16 Karakter")
    @Pattern(regexp = "\\d+", message = "No KTP Harus Berupa Angka")
    private String nik;

    @Size(min = 10, max = 15, message = "Nomor Handphone Harus 10-15 Digit")
    @Pattern(regexp = "\\d+", message = "Nomor Handphone Harus Berupa Angka")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
