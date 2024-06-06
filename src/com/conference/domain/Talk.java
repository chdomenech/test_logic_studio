package com.conference.domain;

/**
 * Clase que representa una charla en la conferencia.
 */
public class Talk {
    private String title;
    private int duration; // Duración en minutos

    public Talk(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
