package com.example.playlist.controller;

import com.example.playlist.model.Playlist;
import com.example.playlist.model.Track;
import com.example.playlist.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist")
public class PlayListController {

    @Autowired
    private final PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Playlist playList) {
        playListService.create(playList);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(playListService.findAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable String id) {
        return ResponseEntity.ok(playListService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        playListService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/track")
    public ResponseEntity addTrack(@RequestBody Track track, @PathVariable String id) {
        playListService.addTrack(track, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}/track")
    public ResponseEntity deleteTrack(@PathVariable String id, @RequestBody Track track) {
        playListService.deleteTrack(track, id);
        return ResponseEntity.ok().build();
    }



}
