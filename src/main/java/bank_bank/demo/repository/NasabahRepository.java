package bank_bank.demo.repository;

import bank_bank.demo.model.Nasabah;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NasabahRepository extends JpaRepository<Nasabah,Long> {

    List<Nasabah> findNasabahByIsDeletedFalse();
    Optional<Nasabah> findNasabahByNikAndIsDeletedFalse(String nik);
    Optional<Nasabah> findByAccountNumber(String accountNumber);

    Boolean existsByNikAndIsDeletedFalse(String nik);
    Boolean existsByAccountNumberAndIsDeletedFalse(String accountNumber);


    @Query("""
    SELECT n FROM Nasabah n\s
    WHERE (:nik IS NULL OR UPPER(n.nik) LIKE UPPER(CONCAT('%', :nik, '%')))
    AND (:nama IS NULL OR UPPER(n.fullName) LIKE UPPER(CONCAT('%', :nama, '%')))
   \s""")
    Page<Nasabah> filterByNikAndNama(@Param("nik") String nik, @Param("nama") String nama, Pageable pageable);
}
