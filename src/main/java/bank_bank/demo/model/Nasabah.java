package bank_bank.demo.model;


import bank_bank.demo.dto.NasabahDTO;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fullName;
    private String address;
    private LocalDate birthDate;
    private String noKtp;
    private String noTelp;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Nasabah mappingFrom(NasabahDTO request){
        this.setName(request.getName() != null ? request.getName() : this.getName());
        this.setFullName(request.getFullName() != null ? request.getFullName() : this.getFullName());
        this.setAddress(request.getAddress() != null ? request.getAddress() : this.getAddress());
        this.setBirthDate(request.getBirthDate() != null ? request.getBirthDate() : this.getBirthDate());
        this.setNoKtp(request.getNoKtp() != null ? request.getNoKtp() : this.getNoKtp());
        this.setNoTelp(request.getNoTelp() != null ? request.getNoTelp() : this.getNoTelp());
        this.setDeleted(false);

        return this;
    }
}
