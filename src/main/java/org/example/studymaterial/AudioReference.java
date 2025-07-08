package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {
    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }

    private AudioQuality audioQuality;

    public AudioReference(AudioQuality quality){
        this.audioQuality = quality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality){
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

    // Método editAudio refatorado para receber o objeto AudioEditParams
    public void editAudio(AudioEditParams params){
        editBasic(params.getTitle(), params.getDescription(), params.getLink());
        this.setAccessRights(params.getAccessRights());
        this.setLicense(params.getLicense());
        this.setAudioQuality(params.getAudioQuality());
        editAudioAttributes(params.getRating(), params.getLanguage(), params.getViewCount(), params.getShareCount(), params.isDownloadable());
    }

    // Método adaptador que cria AudioEditParams e chama editAudio
    public void editAudioAdapter(List<String> properties, List<Integer> intProperties, AudioQuality audioQuality, boolean isDownloadable){
        AudioEditParams params = new AudioEditParams(
                audioQuality,
                isDownloadable,
                properties.get(0), // title
                properties.get(1), // description
                properties.get(2), // link
                properties.get(3), // accessRights
                properties.get(4), // license
                properties.get(5), // language
                intProperties.get(0), // rating
                intProperties.get(1), // viewCount
                intProperties.get(2)  // shareCount
        );
        this.editAudio(params);
    }

    private void editAudioAttributes(int rating, String language, int viewCount, int shareCount, boolean isDownloadable){
        this.setRating(rating);
        this.setShareCount(shareCount);
        this.setViewCount(viewCount);
        this.setDownloadable(isDownloadable);
        this.setLanguage(language);
    }

    public void editBasic(String title, String description, String link){
        this.setTitle(title);
        this.setDescription(description);
        this.setLink(link);
    }
}
