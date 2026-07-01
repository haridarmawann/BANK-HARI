package bank_bank.demo.repository;

import bank_bank.demo.model.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NasabahRepository extends JpaRepository<Nasabah,Integer> {

    List<Nasabah> findNasabahByIsDeletedFalse();
    Optional<Nasabah> findNasabahByNoKtpAndIsDeletedFalse(String noKtp);

    Boolean existsByNoKtpAndIsDeletedFalse(String noKtp);
}
