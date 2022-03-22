package com.seng405.imdbtopmovies.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Parcelable;

public class TopMovieResult implements Parcelable
{

    private List<TopMovieItem> items = null;
    private String errorMessage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<TopMovieResult> CREATOR = new Creator<TopMovieResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TopMovieResult createFromParcel(android.os.Parcel in) {
            return new TopMovieResult(in);
        }

        public TopMovieResult[] newArray(int size) {
            return (new TopMovieResult[size]);
        }

    }
            ;

    protected TopMovieResult(android.os.Parcel in) {
        in.readList(this.items, (com.seng405.imdbtopmovies.Entity.TopMovieItem.class.getClassLoader()));
        this.errorMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public TopMovieResult() {
    }

    public List<TopMovieItem> getItems() {
        return items;
    }

    public void setItems(List<TopMovieItem> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(items);
        dest.writeValue(errorMessage);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}