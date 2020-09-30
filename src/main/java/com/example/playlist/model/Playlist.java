package com.example.playlist.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Playlist {

    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private String userId;

    public Playlist(String name, String description, int followersCount, List<Track> tracks, String userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.userId = userId;
    }
}
