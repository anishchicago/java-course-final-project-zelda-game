package _04interfaces.P9_23;

import java.util.Date;

public class OneTime extends Appointment {

    public OneTime(String description, Date date) {
        super(description, date);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        return (this.getDate().getYear() == year &&
                this.getDate().getMonth() == month &&
                this.getDate().getDate() == day);
    }

    @Override
    public String getType() {
        return "ONE_TIME";
    }

}
