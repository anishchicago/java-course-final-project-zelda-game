package _03objects.P8_11;

import java.util.ArrayList;

public class Letter {

    private String from;
    private String to;
    private ArrayList<String> lines = new ArrayList<String>();

    public Letter(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public String getText() {
        String text = "Dear " + to +":\n \n";

        for (String line : lines) {
            text += line + "\n";
        }

        text += "\n";

        text += "Sincerely, \n \n" + from;
        return text;
    }

}
