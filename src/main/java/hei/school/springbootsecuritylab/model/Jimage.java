package hei.school.springbootsecuritylab.model;

public record Jimage(
        String id,
        String filePath,
        String fileType,
        String downloadUrl
) {
}
