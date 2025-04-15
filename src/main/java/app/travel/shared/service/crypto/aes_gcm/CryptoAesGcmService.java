package app.travel.shared.service.crypto.aes_gcm;

import app.travel.value.AppCoreValue;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CryptoAesGcmService implements ICryptoAesGcmService{

    static{
        Security.addProvider(new BouncyCastleProvider());
    }

    AppCoreValue appCoreValue;

    @NonFinal
    SecretKey secretKey;

    @PostConstruct
    void init(){
        secretKey = Keys.hmacShaKeyFor(appCoreValue.getServerSecretKey().getBytes(StandardCharsets.UTF_8));
    }

    static String ALGORITHM = "AES/GCM/NoPadding";
    static String PROVIDER = "BC";
    static Integer GCM_TAG_LENGTH_BIT = 128;
    static Integer IV_LENGTH = 12;
    static byte[] IV = new byte[IV_LENGTH];

    public String encode(String originalText) throws Exception {

        Cipher cipher = Cipher.getInstance(ALGORITHM, PROVIDER);

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BIT, IV);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

        byte[] encryptedByte = cipher.doFinal(originalText.getBytes());

        return Base64.getUrlEncoder().encodeToString(encryptedByte);
    }

    public String decode(String encryptedText) throws Exception {

        Cipher cipher = Cipher.getInstance(ALGORITHM, PROVIDER);

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BIT, IV);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);

        byte[] decryptedByte = cipher.doFinal(Base64.getUrlDecoder().decode(encryptedText));

        return new String(decryptedByte);
    }

}
