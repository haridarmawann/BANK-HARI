package bank_bank.demo.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class NasabahDTO {
    private String name;
    @NotBlank(message = "full name is required")
    private String fullName;
    private String address;
    private LocalDate birthDate;
    @NotBlank(message = "nik is required")
    private String noKtp;
    private String noTelp;

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

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
