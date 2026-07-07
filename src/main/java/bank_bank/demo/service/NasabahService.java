package bank_bank.demo.service;

import bank_bank.demo.dto.request.NasabahDTO;
import bank_bank.demo.dto.request.UpdateNasabahDTO;
import bank_bank.demo.dto.response.PaginationResponse;
import bank_bank.demo.model.Nasabah;
import java.util.List;

public interface NasabahService {

    Nasabah createNasabah(NasabahDTO request);
    Nasabah findById(Long id);
    Nasabah findByAccountNumber(String accountNumber);
    List<Nasabah> findAll();
    Nasabah updateNasabah(Long id, UpdateNasabahDTO request);
    void deleteNasabah(Long id);
    Nasabah findByNoKtp(String nik);
    PaginationResponse<Nasabah> PaginatedParamFiltered(String nik, String nama, int page, int size);
}
