import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class walletTest {

    @Test
    void testConstructor() {
        wallet wallet = new wallet("Budi");
        assertEquals("Budi", wallet.getOwner());
        assertEquals(0, wallet.getBalance());
        assertTrue(wallet.getCards().isEmpty());
    }

    @Test
    void testSetOwner() {
        wallet wallet = new wallet("Budi");
        wallet.setOwner("Ani");
        assertEquals("Ani", wallet.getOwner());
    }

    @Test
    void testAddCard() {
        wallet wallet = new wallet("Budi");
        wallet.addCard(new Card("Kredit", "1234-5678-9012-3456"));
        wallet.addCard(new Card("ATM", "4567-8901-2345-6789"));
        assertEquals(2, wallet.getCards().size());
    }



    @Test
    void testAddCash() {
        wallet wallet = new wallet("Budi");
        wallet.addCash(100000);
        assertEquals(100000, wallet.getBalance());

        wallet.addCash(-50000);
        assertEquals(100000, wallet.getBalance());
    }

    @Test
    void testWithdrawCash() {
        wallet wallet = new wallet("Budi");
        wallet.addCash(100000);

        int withdrawnAmount = wallet.withdrawCash(50000);
        assertEquals(50000, withdrawnAmount);
        assertEquals(50000, wallet.getBalance());

        withdrawnAmount = wallet.withdrawCash(150000);
        assertEquals(0, withdrawnAmount);
        assertEquals(50000, wallet.getBalance());
    }
}