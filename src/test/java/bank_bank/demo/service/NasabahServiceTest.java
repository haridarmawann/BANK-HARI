package bank_bank.demo.service;

import bank_bank.demo.dto.request.NasabahDTO;
import bank_bank.demo.model.Nasabah;
import bank_bank.demo.repository.NasabahRepository;
import bank_bank.demo.service.impl.NasabahServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NasabahServiceTest {

    @Mock
    private NasabahRepository nasabahRepository;

    @InjectMocks
    private NasabahServiceImpl nasabahService;

    private NasabahDTO validRequest;

    @BeforeEach
    void setUp() {
        validRequest = new NasabahDTO();
        validRequest.setFullName("Hari Darmawan");
        validRequest.setAddress("Jakarta");
        validRequest.setBirthDate(LocalDate.of(1995, 5, 15));
        validRequest.setNik("1234567890123456");
        validRequest.setPhone("081234567890");
        validRequest.setAccountNumber("1234567890");
    }

    @Test
    void createNasabah_success() {
        when(nasabahRepository.existsByNikAndIsDeletedFalse(validRequest.getNik()))
                .thenReturn(false);
        when(nasabahRepository.save(any(Nasabah.class)))
                .thenAnswer(invocation -> {
                    Nasabah saved = invocation.getArgument(0);
                    saved.setId(1L);
                    return saved;
                });

        Nasabah result = nasabahService.createNasabah(validRequest);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Hari Darmawan", result.getFullName());
        assertEquals("Jakarta", result.getAddress());
        assertEquals("1234567890123456", result.getNik());
        assertEquals("081234567890", result.getPhone());
        assertFalse(result.getDeleted());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());

        verify(nasabahRepository).existsByNikAndIsDeletedFalse(validRequest.getNik());
        verify(nasabahRepository).save(any(Nasabah.class));
    }

    @Test
    void createNasabah_duplicateNoKtp_throwsException() {
        when(nasabahRepository.existsByNikAndIsDeletedFalse(validRequest.getNik()))
                .thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> nasabahService.createNasabah(validRequest)
        );

        assertEquals("Data Nasabah Sudah Ada No KTP: 1234567890123456", exception.getMessage());
        verify(nasabahRepository, never()).save(any());
    }

    @Test
    void createNasabah_duplicateAccountNumber_throwsException() {
        when(nasabahRepository.existsByNikAndIsDeletedFalse(validRequest.getNik()))
                .thenReturn(false);
        when(nasabahRepository.existsByAccountNumberAndIsDeletedFalse(validRequest.getAccountNumber()))
                .thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> nasabahService.createNasabah(validRequest)
        );

        assertEquals("Data Nasabah Sudah Ada No Rekening: 1234567890", exception.getMessage());
        verify(nasabahRepository, never()).save(any());
    }

}
