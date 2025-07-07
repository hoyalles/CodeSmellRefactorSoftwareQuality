package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {

    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }

    private AudioQuality audioQuality;

    public AudioReference(AudioQuality quality) {
        this.audioQuality = quality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality) {
        return switch (quality.toLowerCase()) {
            case "low" -> AudioQuality.LOW;
            case "medium" -> AudioQuality.MEDIUM;
            case "high" -> AudioQuality.HIGH;
            case "very_high" -> AudioQuality.VERY_HIGH;
            default -> null;
        };
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    // Novo método editAudio que recebe o objeto AudioEditParams
    public void editAudio(AudioEditParams params) {
        editBasic(params.getTitle(), params.getDescription(), params.getLink());
        this.setAccessRights(params.getAccessRights());
        this.setLicense(params.getLicense());
        this.setAudioQuality(params.getAudioQuality());
        editVideoAttributes(params.getRating(), params.getLanguage(), params.getViewCount(), params.getShareCount(), params.isDownloadable());
    }

    // Adapter atualizado para usar o novo método
    public void editAudioAdapter(List<String> properties, List<Integer> intProperties, AudioQuality audioQuality, boolean isDownloadable) {
        AudioEditParams params = new AudioEditParams(
                audioQuality,
                isDownloadable,
                properties.get(0),
                properties.get(1),
                properties.get(2),
                properties.get(3),
                properties.get(4),
                properties.get(5),
                intProperties.get(0),
                intProperties.get(1),
                intProperties.get(2)
        );
        this.editAudio(params);
    }

    private void editVideoAttributes(int rating, String language, int viewCount, int shareCount, boolean isDownloadable) {
        this.setRating(rating);
        this.setShareCount(shareCount);
        this.setViewCount(viewCount);
        this.setDownloadable(isDownloadable);
        this.setLanguage(language);
    }

    public void editBasic(String title, String description, String link) {
        this.setTitle(title);
        this.setDescription(description);
        this.setLink(link);
    }

}
