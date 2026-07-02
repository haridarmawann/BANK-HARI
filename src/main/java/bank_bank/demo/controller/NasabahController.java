package bank_bank.demo.controller;

import bank_bank.demo.dto.NasabahDTO;
import bank_bank.demo.dto.response.ApiResponse;
import bank_bank.demo.dto.response.PaginationResponse;
import bank_bank.demo.model.Nasabah;
import bank_bank.demo.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/nasabah")
@RestController
public class NasabahController {
    @Autowired
    private NasabahService nasabahService;

    @PostMapping
    public ResponseEntity<ApiResponse<Nasabah>> createNasabah(@RequestBody NasabahDTO request) {
        Nasabah response = nasabahService.createNasabah(request);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil dibuat", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Nasabah>>> getListNasabah() {
        List<Nasabah> response = nasabahService.findAll();
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Didapatkan", response));
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse<PaginationResponse<Nasabah>>> getListPaginatedNasabah(  @RequestParam(required = false) String nik,
                                                                                              @RequestParam(required = false) String nama,
                                                                                              @RequestParam(defaultValue = "0") int page,
                                                                                              @RequestParam(defaultValue = "10") int size) {
        PaginationResponse<Nasabah> response = nasabahService.PaginatedParamFiltered(nik,nama,page,size);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Didapatkan", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Nasabah>> getNasabahById(@PathVariable Long id) {
        Nasabah response = nasabahService.findById(id);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Didapatkan", response));
    }
    @GetMapping("/ktp/{noKtp}")
    public ResponseEntity<ApiResponse<Nasabah>> getNasabahByNoKtp(@PathVariable String noKtp) {
        Nasabah response = nasabahService.findByNoKtp(noKtp);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Didapatkan", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Nasabah>> updateNasabah(@PathVariable Long id, @RequestBody NasabahDTO request) {
        Nasabah response = nasabahService.updateNasabah(id,request);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Diubah", response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Nasabah>> deleteNasabah(@PathVariable Long id) {
        nasabahService.deleteNasabah(id);
        return ResponseEntity.ok(ApiResponse.success("Nasabah berhasil Dihapus", null));
    }
}
