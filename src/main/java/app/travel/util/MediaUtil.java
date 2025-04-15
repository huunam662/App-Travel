package app.travel.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MediaUtil {

    public static String typeFile(String fileName){

        if(fileName == null || fileName.trim().isEmpty())
            return null;

        String fileNameLower = fileName.trim().toLowerCase();

        int lastIndexOfDot = fileNameLower.lastIndexOf(".");

        if(lastIndexOfDot == -1 || lastIndexOfDot + 1 == fileNameLower.length())
            return null;

        return switch (fileNameLower.substring(lastIndexOfDot + 1)){
            case "jpa", "jpeg", "png", "gif", "bmp", "svg", "webp" -> "image";
            case "mp3", "wav", "ogg", "flac", "m4a" -> "audio";
            case "mp4", "avi", "mkv", "mov", "flv" -> "video";
            case "txt", "doc", "docx", "pdf", "xls", "xlsx", "ppt", "pptx" -> "document";
            default -> "text";
        };
    }

    public static String formatFile(String fileName){

        if(fileName == null || fileName.trim().isEmpty())
            return null;

        String fileNameLower = fileName.trim().toLowerCase();

        int lastIndexOfDot = fileNameLower.lastIndexOf(".");

        if(lastIndexOfDot == -1 || lastIndexOfDot + 1 == fileNameLower.length())
            return null;

        return fileNameLower.substring(lastIndexOfDot + 1);
    }

}
