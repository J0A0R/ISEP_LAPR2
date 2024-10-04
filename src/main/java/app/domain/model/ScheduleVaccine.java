package app.domain.model;

import java.time.LocalDateTime;

public class ScheduleVaccine {

    private User user;
    private VaccineType vaccineType;
    private VaccinationCenter vaccinationCenter;
    private LocalDateTime date;
    private SMSNotification notification;

    public ScheduleVaccine(User user, VaccineType vaccineType, VaccinationCenter vaccinationCenter, LocalDateTime date, SMSNotification notification) {
        this.user = user;
        this.vaccineType = vaccineType;
        this.vaccinationCenter = vaccinationCenter;
        this.date = date;
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public SMSNotification getNotification() {
        return notification;
    }

    public void setNotification(SMSNotification notification) {
        this.notification = notification;
    }
}
