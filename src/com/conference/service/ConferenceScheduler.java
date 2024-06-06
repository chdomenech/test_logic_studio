package com.conference.service;

import java.util.ArrayList;
import java.util.List;

import com.conference.domain.ConferenceTrack;
import com.conference.domain.Talk;

/**
 * Servicio para programar las charlas de la conferencia.
 */
 
public class ConferenceScheduler {

    /**
    * Programa las charlas en las sesiones disponibles.
    * 
    * @param talks Lista de charlas a programar
    * @return Conferencia con las charlas programadas
    */
    public List<ConferenceTrack> scheduleConference(List<Talk> talks) {
        List<ConferenceTrack> tracks = new ArrayList<>();
        ConferenceTrack currentTrack = new ConferenceTrack();
        tracks.add(currentTrack);

        for (Talk talk : talks) {
            boolean added = currentTrack.getMorningSession().addTalk(talk);
            if (!added) {
                added = currentTrack.getAfternoonSession().addTalk(talk);
            }
            if (!added) {
                currentTrack = new ConferenceTrack();
                tracks.add(currentTrack);
                currentTrack.getMorningSession().addTalk(talk);
            }
        }

        return tracks;
    }
}
