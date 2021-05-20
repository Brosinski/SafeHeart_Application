public class ErrorAvoidance {

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            System.out.println("THIS WORKED WHYYYYYY");
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }
}
