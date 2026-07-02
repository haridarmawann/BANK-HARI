package bank_bank.demo.service;

import bank_bank.demo.dto.NasabahDTO;
import bank_bank.demo.model.Nasabah;
import bank_bank.demo.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NasabahService {

    @Autowired
    private NasabahRepository nasabahRepository;

    public Nasabah createNasabah(NasabahDTO request){
        validate(request);
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

    public Nasabah findById(Integer id){
        return nasabahRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nasabah tidak ditemukan"));
    }

    public List<Nasabah> findAll(){
        return nasabahRepository.findNasabahByIsDeletedFalse();
    }

    public Nasabah updateNasabah(Integer id,NasabahDTO request){
        Nasabah nasabah = findById(id);

        nasabah.setBirthPlace(request.getBirthPlace() != null ? request.getBirthPlace() : nasabah.getBirthPlace());
        nasabah.setAddress(request.getAddress() != null ? request.getAddress() : nasabah.getAddress());
        nasabah.setBirthDate(request.getBirthDate() != null ? request.getBirthDate() : nasabah.getBirthDate());
        nasabah.setPhone(request.getPhone() != null ? request.getPhone() : nasabah.getPhone());
        nasabah.setUpdatedAt(LocalDateTime.now());

        return nasabahRepository.save(nasabah);
    }

    public void deleteNasabah(Integer id){
        Nasabah nasabah = findById(id);
        nasabah.setDeleted(true);
        nasabah.setUpdatedAt(LocalDateTime.now());

        nasabahRepository.save(nasabah);
    }
    public Nasabah findByNoKtp(String nik){
        return nasabahRepository.findNasabahByNikAndIsDeletedFalse(nik)
                .orElseThrow(() -> new IllegalArgumentException("Nasabah tidak ditemukan"));
    }

    private void validate(NasabahDTO request){
        if (request.getFullName() == null){
            throw new IllegalArgumentException("Nama Harus Diisi");
        }
        if (request.getNik() == null){
            throw new IllegalArgumentException("No KTP Harus Diisi");
        }
        if (request.getNik().length() != 16){
            throw new IllegalArgumentException("No KTP Harus 16 Karakter");
        }
    }
}
