package _04interfaces.P9_23;

import java.util.Date;

public class Daily extends Appointment {

    public Daily(String description, Date date) {
        super(description, date);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        if (this.getDate().getYear() >= year && this.getDate().getMonth() >= month
            && this.getDate().getDate() >= day)
            return true;
        else return false;
    }

    @Override
    public String getType() {
        return "DAILY";
    }
}
