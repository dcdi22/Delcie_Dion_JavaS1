package com.company.reccolldao.service;

import com.company.reccolldao.dao.AlbumDao;
import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.dao.TrackDao;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewModel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServiceLayer {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    @Transactional
    public AlbumViewModel buildAlbum(Album album) {
        Artist artist = artistDao.getArtist(album.getArtistId());

        Label label = labelDao.getLabel(album.getLabelId());

        List<Track> trackList = trackDao.getTracksByAlbum(album.getId());

        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist);
        avm.setLabel(label);
        avm.setTrackList(trackList);

        return avm;

    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel vm) {
        Album a = new Album();
        a.setTitle(vm.getTitle());
        a.setReleaseDate(vm.getReleaseDate());
        a.setLabelId(vm.getLabel().getId());
        a.setArtistId(vm.getArtist().getId());
        a = albumDao.addAlbum(a);
        vm.setId(a.getId());

        List<Track> tracks = vm.getTrackList();

        tracks.stream()
                .forEach(t -> {
                    t.setAlbumId(vm.getId());
                });

        tracks = trackDao.getTracksByAlbum(vm.getId());
        vm.setTrackList(tracks);

        return vm;
    }

    @Transactional
    public AlbumViewModel findAlbum(int id) {
        Album album = albumDao.getAlbum(id);
        return buildAlbum(album);
    }

    @Transactional
    public List<AlbumViewModel> findAllAlbums() {
        List<Album> albumList = albumDao.getAllAlbums();
        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album: albumList) {
            AlbumViewModel avm = buildAlbum(album);
            avmList.add(avm);
        }
        return avmList;
    }


}
