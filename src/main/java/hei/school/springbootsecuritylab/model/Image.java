package hei.school.springbootsecuritylab.model;

public record Image(
        String id,
        String filePath,
        String fileType,
        String downloadUrl
) {
}
