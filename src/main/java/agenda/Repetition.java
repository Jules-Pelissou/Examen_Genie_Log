package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Repetition {
    public ChronoUnit getFrequency() {
        return myFrequency;
    }

    /**
     * Stores the frequency of this repetition, one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private final ChronoUnit myFrequency;
    private Termination myTermination;
    private ArrayList<LocalDate> myExceptionDates;

    public Repetition(ChronoUnit myFrequency) {
        this.myFrequency = myFrequency;
        this.myExceptionDates = new ArrayList<>();
    }

    /**
     * Les exceptions à la répétition
     * @param date un date à laquelle l'événement ne doit pas se répéter
     */
    public void addException(LocalDate date) {
        myExceptionDates.add(date);
    }

    /**
     * La terminaison d'une répétition (optionnelle)
     * @param termination la terminaison de la répétition
     */
    public void setMyTermination(Termination termination) {
        this.myTermination = termination;
    }

    public Termination getMyTermination() {
        return myTermination;
    }

    // Getter liste exception
    public ArrayList<LocalDate> getMyExceptionDates() {
        return myExceptionDates;
    }
}
