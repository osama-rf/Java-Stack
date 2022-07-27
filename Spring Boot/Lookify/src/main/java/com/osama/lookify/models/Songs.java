package com.osama.lookify.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 5, message = "Title must be at least 5 characters")
    private String title;

    @NotNull
    @Size(min = 5, message = "Artist name must be at least 5 characters")
    private String artist;

    @NotNull
    @Min(value = 1, message = "Rate must be a number between 1 and 10")
    @Max(value = 10, message = "Rate must be a number between 1 and 10")
    private int rate;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd:hh:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd:hh:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Songs (){}

    public Songs(String title, String artist, int rate){
        this.title = title;
        this.artist = artist;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
