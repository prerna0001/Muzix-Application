//package com.stackroute.muzix.seeddata;
//
//import com.stackroute.muzix.model.Track;
//import com.stackroute.muzix.services.TrackService;
//import lombok.Data;
//import lombok.Value;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@PropertySource("classpath:application.properties")
//@Value
//@Component
//@Data
//
//public class SeedData implements CommandLineRunner {
//
//    @Autowired
//    TrackService trackService;
//
//    @Autowired
//    Environment environment;
//
// //   @Autowired
//    Track track=new Track();
//
//    @Override
//    public void run(String... args) throws Exception {
//        track.setTrackName(environment.getProperty("trackName"));
//        System.out.println("its done");
//        trackService.addMusicTrack(track);
//        System.out.println(trackService.toString());
//    }
//
//
//}
