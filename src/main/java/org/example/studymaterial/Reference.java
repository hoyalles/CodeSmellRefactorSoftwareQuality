package org.example.studymaterial;

public abstract class Reference {
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private boolean isDownloadable;
    private int rating; // 0–5
    private String language;
    private int viewCount;
    private int downloadCount;
    private int shareCount;

    // Métodos com comportamento (evitando apenas setters/gets)

    public void view() {
        this.viewCount++;
    }

    public void download() {
        if (isDownloadable) {
            this.downloadCount++;
        } else {
            throw new IllegalStateException("Download não permitido para esta referência.");
        }
    }

    public void share() {
        this.shareCount++;
    }

    public boolean isPublicAccess() {
        return "public".equalsIgnoreCase(accessRights);
    }

    public boolean isHighRated() {
        return rating >= 4;
    }

    public String summary() {
        return String.format("'%s' (%s) - Avaliação: %d/5 - Idioma: %s", title, description, rating, language);
    }

    public double popularityScore() {
        return viewCount * 0.5 + downloadCount * 1.5 + shareCount * 2.0;
    }

    public boolean isRelevant() {
        return popularityScore() > 100 || isHighRated();
    }

    // Getters e setters reduzidos apenas ao necessário

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ... (outros getters/setters mantidos se forem necessários por requisitos externos/testes)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public boolean getIsDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        isDownloadable = downloadable;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    protected void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    protected void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

}
