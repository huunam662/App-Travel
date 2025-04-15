package app.travel.common.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum FolderUpload {

    PROFILE_USER("profile-user");

    String folder;

    FolderUpload(String folder) {
        this.folder = folder;
    }



}
