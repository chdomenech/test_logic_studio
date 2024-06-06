package test;

import com.conference.domain.ConferenceTrack;
import com.conference.domain.Talk;
import com.conference.service.ConferenceScheduler;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ConferenceScheduler.
 */
public class ConferenceSchedulerTest {

    @Test
    public void testScheduleConference() {
        List<Talk> talks = Arrays.asList(
            new Talk("Writing Fast Tests Against Enterprise Rails", 60),
            new Talk("Overdoing it in Python", 45),
            new Talk("Lua for the Masses", 30),
            new Talk("Ruby Errors from Mismatched Gem Versions", 45),
            new Talk("Common Ruby Errors", 45),
            new Talk("Rails for Python Developers", 5),
            new Talk("Communicating Over Distance", 60),
            new Talk("Accounting-Driven Development", 45),
            new Talk("Woah", 30),
            new Talk("Sit Down and Write", 30),
            new Talk("Pair Programming vs Noise", 45),
            new Talk("Rails Magic", 60),
            new Talk("Ruby on Rails: Why We Should Move On", 60),
            new Talk("Clojure Ate Scala (on my project)", 45),
            new Talk("Programming in the Boondocks of Seattle", 30),
            new Talk("Ruby vs. Clojure for Back-End Development", 30),
            new Talk("Ruby on Rails Legacy App Maintenance", 60),
            new Talk("A World Without HackerNews", 30),
            new Talk("User Interface CSS in Rails Apps", 30)
        );

        ConferenceScheduler scheduler = new ConferenceScheduler();
        List<ConferenceTrack> tracks = scheduler.scheduleConference(talks);

        for (ConferenceTrack track : tracks) {
            assertFalse(track.getMorningSession().getTalks().isEmpty());
            assertFalse(track.getAfternoonSession().getTalks().isEmpty());

            track.printSchedule();
        }
    }
    
    @Test
    public void testAddTalkToMorningSession() {
        ConferenceTrack track = new ConferenceTrack();
        Talk talk = new Talk("Writing Fast Tests Against Enterprise Rails", 60);
        assertTrue(track.getMorningSession().addTalk(talk));
        assertEquals(1, track.getMorningSession().getTalks().size());
    }

    @Test
    public void testAddTalkToAfternoonSession() {
        ConferenceTrack track = new ConferenceTrack();
        Talk talk = new Talk("Communicating Over Distance", 60);
        assertTrue(track.getAfternoonSession().addTalk(talk));
        assertEquals(1, track.getAfternoonSession().getTalks().size());
    }
    
    
}
