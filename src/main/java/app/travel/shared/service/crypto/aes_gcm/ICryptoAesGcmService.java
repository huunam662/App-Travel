package app.travel.shared.service.crypto.aes_gcm;

public interface ICryptoAesGcmService {

    String encode(String originalText) throws Exception;

    String decode(String encryptedText) throws Exception;

}
