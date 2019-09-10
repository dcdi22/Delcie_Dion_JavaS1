package com.company.reccolldao.viewModel;

import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumViewModel {

    private int id;
    private Artist artist;
    private Label label;
    private List<Track> trackList = new ArrayList<>();
    private String title;
    private LocalDate releaseDate;
    private BigDecimal listPrice;

    public AlbumViewModel() {
    }

    public AlbumViewModel(int id, Artist artist, Label label, List<Track> trackList, String title, LocalDate releaseDate, BigDecimal listPrice) {
        this.id = id;
        this.artist = artist;
        this.label = label;
        this.trackList = trackList;
        this.title = title;
        this.releaseDate = releaseDate;
        this.listPrice = listPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumViewModel that = (AlbumViewModel) o;
        return id == that.id &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(label, that.label) &&
                Objects.equals(trackList, that.trackList) &&
                Objects.equals(title, that.title) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(listPrice, that.listPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, label, trackList, title, releaseDate, listPrice);
    }
}
