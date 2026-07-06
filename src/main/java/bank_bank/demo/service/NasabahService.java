package bank_bank.demo.service;

import bank_bank.demo.dto.request.NasabahDTO;
import bank_bank.demo.dto.request.UpdateNasabahDTO;
import bank_bank.demo.dto.response.PaginationResponse;
import bank_bank.demo.model.Nasabah;
import bank_bank.demo.repository.NasabahRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NasabahService {

    private static final Logger log = LoggerFactory.getLogger(NasabahService.class);

    @Autowired
    private NasabahRepository nasabahRepository;

    public Nasabah createNasabah(NasabahDTO request){
        log.info("Creating nasabah with NIK: {}", request.getNik());
        Boolean checkNasabah = nasabahRepository.existsByNikAndIsDeletedFalse(request.getNik());
        if (checkNasabah == true){
            throw new IllegalArgumentException("Data Nasabah Sudah Ada No KTP: " + request.getNik());
        }
        Nasabah nasabah = new Nasabah().mappingFrom(request);
        nasabah.setDeleted(false);
        nasabah.setCreatedAt(LocalDateTime.now());
        nasabah.setUpdatedAt(LocalDateTime.now());

       return nasabahRepository.save(nasabah);
    }

    public Nasabah findById(Long id){
        return nasabahRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nasabah tidak ditemukan"));
    }

    public Nasabah findByAccountNumber(String accountNumber){
        return nasabahRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Nasabah tidak ditemukan"));
    }

    public List<Nasabah> findAll(){
        return nasabahRepository.findNasabahByIsDeletedFalse();
    }

    public Nasabah updateNasabah(Long id, UpdateNasabahDTO request){
        Nasabah nasabah = findById(id);
        log.info("Updating nasabah with NIK: {}", nasabah.getId());

        nasabah.setBirthPlace(request.getBirthPlace() != null ? request.getBirthPlace() : nasabah.getBirthPlace());
        nasabah.setAddress(request.getAddress() != null ? request.getAddress() : nasabah.getAddress());
        nasabah.setBirthDate(request.getBirthDate() != null ? request.getBirthDate() : nasabah.getBirthDate());
        nasabah.setPhone(request.getPhone() != null ? request.getPhone() : nasabah.getPhone());
        nasabah.setUpdatedAt(LocalDateTime.now());

        return nasabahRepository.save(nasabah);
    }

    public void deleteNasabah(Long id){
        Nasabah nasabah = findById(id);
        nasabah.setDeleted(true);
        nasabah.setUpdatedAt(LocalDateTime.now());

        nasabahRepository.save(nasabah);

        log.info("Success deleted nasabah with Id: {}", nasabah.getId());
    }
    public Nasabah findByNoKtp(String nik){
        return nasabahRepository.findNasabahByNikAndIsDeletedFalse(nik)
                .orElseThrow(() -> new IllegalArgumentException("Nasabah tidak ditemukan"));
    }


    public PaginationResponse<Nasabah> PaginatedParamFiltered(
            String nik,
            String nama,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Nasabah> result = nasabahRepository.filterByNikAndNama(nik, nama, pageable);

        return new PaginationResponse<>(
                result.getContent(),
                size,
                result.getNumberOfElements(),
                page,
                result.getTotalElements()
        );
    }
}
