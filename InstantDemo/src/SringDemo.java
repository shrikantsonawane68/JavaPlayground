public class SringDemo {
    public static void main(String[] args) {
        String S1= "Hello";
        String S2= "Hello";
        System.out.println("S1 == S2 : " + (S1==S2));
        System.out.println("S1.equals(S2) : " + (S1.equals(S2)));
        System.out.println("S1.hashCode() : " + S1.hashCode());
        System.out.println("S2.hashCode() : " + S2.hashCode());

        String S3 = new String("Hello");
        String S4 = new String("Hello");

        System.out.println("S3 == S4 : " + (S3==S4));
        System.out.println("S3.equals(S4) : " + (S3.equals(S4)));
        System.out.println("S3.hashCode() : " + S3.hashCode());
        System.out.println("S4.hashCode() : " + S4.hashCode());
    }
}
