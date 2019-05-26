package com.stackroute.muzix.services;

import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TrackService {
    public Track addMusicTrack(Track track);
    public List<Track> getAllMusicTracks();
    public void deleteMusicTrack(int trackId) throws TrackNotFoundException;
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
