package org.example.studymaterial;

public class AudioEditParams {
    private AudioReference.AudioQuality audioQuality;
    private boolean isDownloadable;
    private Metadata metadata;
    private Statistics statistics;

    public AudioEditParams(AudioReference.AudioQuality audioQuality, boolean isDownloadable,
                           String title, String description, String link,
                           String accessRights, String license, String language,
                           int rating, int viewCount, int shareCount) {
        this.audioQuality = audioQuality;
        this.isDownloadable = isDownloadable;
        this.metadata = new Metadata(title, description, link, accessRights, license, language);
        this.statistics = new Statistics(rating, viewCount, shareCount);
    }

    // Classes internas para agrupar informações relacionadas
    private static class Metadata {
        private String title;
        private String description;
        private String link;
        private String accessRights;
        private String license;
        private String language;

        public Metadata(String title, String description, String link,
                        String accessRights, String license, String language) {
            this.title = title;
            this.description = description;
            this.link = link;
            this.accessRights = accessRights;
            this.license = license;
            this.language = language;
        }
    }

    private static class Statistics {
        private int rating;
        private int viewCount;
        private int shareCount;

        public Statistics(int rating, int viewCount, int shareCount) {
            this.rating = rating;
            this.viewCount = viewCount;
            this.shareCount = shareCount;
        }
    }

    // Getters
    public AudioReference.AudioQuality getAudioQuality() { return audioQuality; }
    public boolean isDownloadable() { return isDownloadable; }
    public String getTitle() { return metadata.title; }
    public String getDescription() { return metadata.description; }
    public String getLink() { return metadata.link; }
    public String getAccessRights() { return metadata.accessRights; }
    public String getLicense() { return metadata.license; }
    public String getLanguage() { return metadata.language; }
    public int getRating() { return statistics.rating; }
    public int getViewCount() { return statistics.viewCount; }
    public int getShareCount() { return statistics.shareCount; }
}
