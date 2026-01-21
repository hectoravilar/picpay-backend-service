package hector.avlr.picpay.repository;

import hector.avlr.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
