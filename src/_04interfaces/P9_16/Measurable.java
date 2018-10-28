package _04interfaces.P9_16;


// Big Java p 449

public interface Measurable {

    double getMeasure();

    public static double average(Measurable[] objects) {

        if (objects.length == 0) { return 0; } double sum = 0;
        for (Measurable obj : objects)
        {
            sum = sum + obj.getMeasure();
        }

        return sum / objects.length; }

    public static Measurable maximum(Measurable[] objects) {

        if (objects.length == 0) {
            return null;
        };

        double maximumMeasure = Double.MIN_VALUE;
        Measurable largestMeasurable = null;

        for (Measurable obj : objects)
        {
            if (obj.getMeasure() > maximumMeasure) {
                maximumMeasure = obj.getMeasure();
                largestMeasurable = obj;
            }
        }

        return largestMeasurable;
    }

}
