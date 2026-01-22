package hector.avlr.picpay.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import hector.avlr.picpay.entity.Wallet;
import hector.avlr.picpay.entity.WalletType;

public record CreateWalletDto(String fullName,
                              @JsonProperty("cpfCnpj") String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {

    public Wallet toWallet() {
        return new Wallet(
                fullName,
                cpfCnpj,
                email,
                password,
                walletType.get()

        );
    }
}
