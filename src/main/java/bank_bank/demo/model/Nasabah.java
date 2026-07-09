package bank_bank.demo.model;


import bank_bank.demo.dto.request.NasabahDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String fullName;
    private String address;
    private LocalDate birthDate;
    @Column(length = 100)
    private String birthPlace;
    @Column(unique = true, length = 16)
    private String nik;
    @Column(length = 15)
    private String phone;
    @Column(unique = true, length = 10)
    private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
    private Boolean isDeleted;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
        this.setFullName(request.getFullName() != null ? request.getFullName() : this.getFullName());
        this.setAddress(request.getAddress() != null ? request.getAddress() : this.getAddress());
        this.setBirthDate(request.getBirthDate() != null ? request.getBirthDate() : this.getBirthDate());
        this.setBirthPlace(request.getBirthPlace()  != null ? request.getBirthPlace() : this.getBirthPlace());
        this.setNik(request.getNik() != null ? request.getNik() : this.getNik());
        this.setPhone(request.getPhone() != null ? request.getPhone() : this.getPhone());
        this.setDeleted(false);
        this.setAccountNumber(request.getAccountNumber() != null ? request.getAccountNumber() : this.getAccountNumber());
        this.setBalance(request.getBalance() != null ? request.getBalance() : this.getBalance());

        return this;
    }
}
