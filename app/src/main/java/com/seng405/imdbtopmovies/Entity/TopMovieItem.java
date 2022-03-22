package com.seng405.imdbtopmovies.Entity;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcelable;

public class TopMovieItem implements Parcelable
{

    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<TopMovieItem> CREATOR = new Creator<TopMovieItem>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TopMovieItem createFromParcel(android.os.Parcel in) {
            return new TopMovieItem(in);
        }

        public TopMovieItem[] newArray(int size) {
            return (new TopMovieItem[size]);
        }

    }
            ;

    protected TopMovieItem(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.rank = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.fullTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.crew = ((String) in.readValue((String.class.getClassLoader())));
        this.imDbRating = ((String) in.readValue((String.class.getClassLoader())));
        this.imDbRatingCount = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public TopMovieItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(rank);
        dest.writeValue(title);
        dest.writeValue(fullTitle);
        dest.writeValue(year);
        dest.writeValue(image);
        dest.writeValue(crew);
        dest.writeValue(imDbRating);
        dest.writeValue(imDbRatingCount);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}