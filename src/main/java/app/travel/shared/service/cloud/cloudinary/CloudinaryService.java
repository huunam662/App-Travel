package app.travel.shared.service.cloud.cloudinary;

import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import app.travel.util.MediaUtil;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryService implements ICloudinaryService{

    Cloudinary cloudinary;

    ICryptoAesGcmService cryptoAesGcmService;

    @Override
    public Map upload(MultipartFile file, String folderName) throws Exception {

        return cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                "overwrite", true,
                "public_id", cryptoAesGcmService.encode(file.getOriginalFilename()),
                "asset_folder", folderName
        ));
    }
}
