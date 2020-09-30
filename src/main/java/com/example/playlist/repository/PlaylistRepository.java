package com.example.playlist.repository;

import com.couchbase.client.java.Collection;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.example.playlist.model.Playlist;
import com.example.playlist.model.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void insert(Playlist PlayList) {
        playlistCollection.insert(PlayList.getId(), PlayList);
    }

    public void remove(String id) {
        playlistCollection.remove(id);
    }

    public Playlist findById(String id) {
        return playlistCollection.get(id).contentAs(Playlist.class);
    }

    public List<Playlist> findAllByUserId(String id) {
        String statement = String.format("Select id, name, description, followersCount, tracks, userId from playlist where userId = '%s'", id);
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }

    public void addTrack(Track track, String id){
        Playlist playlist =  findById(id);
        playlist.getTracks().add(track);
        playlistCollection.replace(playlist.getId(),playlist);
    }
    public void deleteTrack(Track track, String id){
        Playlist playlist =  findById(id);
        playlist.getTracks().remove(track);
        playlistCollection.replace(playlist.getId(),playlist);
    }

}
