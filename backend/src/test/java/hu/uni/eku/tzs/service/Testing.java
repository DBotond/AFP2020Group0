package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.BillDao;
import hu.uni.eku.tzs.dao.ComplexNumberDao;
import hu.uni.eku.tzs.dao.GuestDao;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.GuestAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class Testing {
    private final BillDao dao = mock(BillDao.class);
    private final GuestDao guestdao = mock(GuestDao.class);
    private BillService service;
    private GuestService guestservice;

    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new BillServiceImpl(dao);
    }

    @BeforeEach
    void setUp2() {
        Mockito.reset(guestdao);
        guestservice = new GuestServiceImpl(guestdao);
    }

    @Test // működik
    void create() throws BillAlreadyExistsException {
        Bill bill = new Bill();
        service.generate(bill);
        verify(dao).create(any());
    }

    @Test // működik
    void recordguest() throws GuestAlreadyExistsException {
        Guest guest = new Guest();
        guestservice.record(guest);
        verify(guestdao).create(any());
    }

    @Test // működik
    void generateExistingBill() {
        Bill bill = new Bill();
        when(dao.readAll()).thenReturn(List.of(bill));
        assertThrows(BillAlreadyExistsException.class, () -> service.generate(bill));
        verify(dao, never()).create(any());
    }
    @Test // működik
    void generateExistingGuest() {
        Guest guest = new Guest();
        when(guestdao.readAll()).thenReturn(List.of(guest));
        assertThrows(GuestAlreadyExistsException.class, () -> guestservice.record(guest));
        verify(guestdao, never()).create(any());
    }

    @Test // működik
    void readAll() {
        Collection<Bill> daoResponse = List.of(
                new Bill(),
                new Bill(),
                new Bill(),
                new Bill()
        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Bill> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }

    @Test // működik
    void readAllGuest() {
        Collection<Guest> daoResponse = List.of(
                new Guest(),
                new Guest(),
                new Guest(),
                new Guest()
        );
        when(guestdao.readAll()).thenReturn(daoResponse);
        Collection<Guest> actual = guestservice.readAll();
        assertEquals(daoResponse,actual);
    }
}