package hector.avlr.picpay.service;

import hector.avlr.picpay.controller.dto.CreateWalletDto;
import hector.avlr.picpay.entity.Wallet;
import hector.avlr.picpay.exception.WalletDataAlreadyExistsException;
import hector.avlr.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;


@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or email already exists");

        }


        return walletRepository.save(dto.toWallet());

    }
}