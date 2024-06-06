package com.conference.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una sesión (mañana o tarde) en la conferencia.
 */
public class Session {
    private List<Talk> talks = new ArrayList<>();
    private int totalDuration;
    private int maxDuration;

    public Session(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public boolean addTalk(Talk talk) {
        if (totalDuration + talk.getDuration() <= maxDuration) {
            talks.add(talk);
            totalDuration += talk.getDuration();
            return true;
        }
        return false;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public int calculateRemainingTime() {
        return maxDuration - totalDuration;
    }
}
