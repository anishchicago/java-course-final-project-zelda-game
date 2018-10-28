package _04interfaces.P9_23;

import java.util.Date;

public class Monthly extends Appointment {

    public Monthly(String description, Date date) {
        super(description, date);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        if (this.getDate().getYear() >= year && this.getDate().getMonth() >= month)
            return this.getDate().getDate() == day;
        else return false;
    }

    @Override
    public String getType() {
        return "MONTHLY";
    }

}
