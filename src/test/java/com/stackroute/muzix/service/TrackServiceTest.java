package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.services.TrackService;
import com.stackroute.muzix.services.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {
    private Track track;


    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackServiceImpl trackServiceImpl;



    List<Track> list= null;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackName("dual");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackServiceImpl.addMusicTrack(track);
        Assert.assertEquals(track,savedTrack);
        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackServiceImpl.addMusicTrack(track);
        System.out.println("savedTrack" + savedTrack);
        Assert.assertEquals(null,savedTrack);
    }

    @Test
    public void getAllTracksTest() throws TrackNotFoundException {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackServiceImpl.getAllMusicTracks();
        Assert.assertEquals(list,tracklist);
    }

}

