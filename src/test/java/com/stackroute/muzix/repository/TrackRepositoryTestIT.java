package com.stackroute.muzix.repository;

import com.stackroute.muzix.model.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class TrackRepositoryTestIT {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackName("ple!!");
        track.setTrackId(3);

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void GetAllTracksTest(){
        Track t1 = new Track(1,"caret");
        Track t2 = new Track(2,"perfect dual");
        trackRepository.save(t1);
        trackRepository.save(t2);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("caret",list.get(0).getTrackName());


    }


    @Test
    public void SaveTrackTest(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(3,fetchTrack.getTrackId());

    }

    @Test
    public void SaveTrackFailureTest(){
        Track testTrack = new Track(60,"Shake");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }

}
