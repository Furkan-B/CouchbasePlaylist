package com.example.playlist.service;

import com.example.playlist.model.Playlist;
import com.example.playlist.model.Track;
import com.example.playlist.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlayListService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void create(Playlist playlist) {
        playlistRepository.insert(playlist);
    }

    public Playlist findById(String id) {
        return playlistRepository.findById(id);
    }


    public List<Playlist> findAllByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void delete(String id) {
        playlistRepository.remove(id);
    }

    public void addTrack(Track track, String id) {
        playlistRepository.addTrack(track, id);
    }

    public void deleteTrack(Track track, String id) {

        playlistRepository.deleteTrack(track, id);
    }



}
