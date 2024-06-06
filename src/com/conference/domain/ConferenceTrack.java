package com.conference.domain;

/**
 * Clase que representa una conferencias con sesiones de mañana y tarde.
 */
public class ConferenceTrack {
    private Session morningSession;
    private Session afternoonSession;

    public ConferenceTrack() {
        morningSession = new Session(180);
        afternoonSession = new Session(240);
    }

    public Session getMorningSession() {
        return morningSession;
    }

    public Session getAfternoonSession() {
        return afternoonSession;
    }

    public void printSchedule() {
        System.out.println("Track:");
        printSession(morningSession, 9);
        System.out.println("12:00PM Lunch");
        printSession(afternoonSession, 13);
        System.out.println("05:00PM Networking Event");
    }

    /**
     * Imprime el horario de la conferencia.
     */
    private void printSession(Session session, int startHour) {
        int currentHour = startHour;
        int currentMinute = 0;
        for (Talk talk : session.getTalks()) {
            System.out.printf("%02d:%02d %s %dmin%n", currentHour, currentMinute, talk.getTitle(), talk.getDuration());
            currentMinute += talk.getDuration();
            while (currentMinute >= 60) {
                currentMinute -= 60;
                currentHour++;
            }
        }
    }
}
