package agenda;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;

    /**
     * Repetition of the event
     */
    private Repetition myRepetition;

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    public void setRepetition(ChronoUnit frequency) {
        this.myRepetition = new Repetition(frequency);
    }

    public void addException(LocalDate date) {
        myRepetition.addException(date);
    }

    public void setTermination(LocalDate terminationInclusive) {
        //Termination t = new Termination()
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public void setTermination(long numberOfOccurrences) {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public int getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        if (myRepetition !=null && myRepetition.getFrequency() == ChronoUnit.DAYS && !myRepetition.getMyExceptionDates().contains(aDay)) {
            return true;
        } else if (myRepetition.getMyExceptionDates().contains(aDay)) {
            return false;
        }

        if ( aDay.isAfter(ChronoLocalDate.from(myStart.plus(myDuration)))  || aDay.isBefore(ChronoLocalDate.from(myStart))) {
                return false;
            }else{
                return true;
            }
        }
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{title='%s', start=%s, duration=%s}".formatted(myTitle, myStart, myDuration);
    }
}
