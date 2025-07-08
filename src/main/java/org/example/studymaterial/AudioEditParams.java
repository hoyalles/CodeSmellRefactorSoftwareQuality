package org.example.studymaterial;

public class AudioEditParams {
    private AudioReference.AudioQuality audioQuality;
    private boolean isDownloadable;
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private String language;
    private int rating;
    private int viewCount;
    private int shareCount;

    public AudioEditParams(AudioReference.AudioQuality audioQuality, boolean isDownloadable, String title, String description,
                           String link, String accessRights, String license, String language,
                           int rating, int viewCount, int shareCount) {
        this.audioQuality = audioQuality;
        this.isDownloadable = isDownloadable;
        this.title = title;
        this.description = description;
        this.link = link;
        this.accessRights = accessRights;
        this.license = license;
        this.language = language;
        this.rating = rating;
        this.viewCount = viewCount;
        this.shareCount = shareCount;
    }

    public AudioReference.AudioQuality getAudioQuality() { return audioQuality; }
    public boolean isDownloadable() { return isDownloadable; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public String getAccessRights() { return accessRights; }
    public String getLicense() { return license; }
    public String getLanguage() { return language; }
    public int getRating() { return rating; }
    public int getViewCount() { return viewCount; }
    public int getShareCount() { return shareCount; }
}
