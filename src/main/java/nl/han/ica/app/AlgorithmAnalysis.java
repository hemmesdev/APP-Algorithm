package nl.han.ica.app;

/**
 * Hello world!
 *
 */
public class AlgorithmAnalysis
{
    public static void main( String[] args )
    {

        int n = 1000000;

        // Fragment 1
        fragment1(n);

        // Fragment 2
        fragment2(n);

        // Fragment 3
        fragment3(n);

        // Fragment 4
        fragment4(n);

        // Fragment 5
        fragment5(n);

        // Fragment 6
        fragment6(n);

        // Fragment 7
        //fragment7(n);

        // Fragment 8
        fragment8(n);

    }

    private static void fragment8(int n) {
        int sum         = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 1; i < n; i = i * 2 ) {
            sum++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 8: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment7(int n) {
        int sum        = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            for (int j = 0; j < n * n; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 7: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment6(int n) {
        int sum        = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 6: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment5(int n) {
        int sum = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 5: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment4(int n) {
        int sum = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            sum++;
        }
        for( int j = 0; j < n; j++ ) {
            sum++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 4: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment3(int n) {
        int sum = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 3: " + (endTime - startTime) + " milliseconds");
    }

    private static void fragment2(int n) {
        int sum = 0;
        long startTime = System.currentTimeMillis();
        for( int i = 0; i < n; i += 2 ) {
            sum++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 2: " +(endTime - startTime) + " milliseconds");
    }

    private static void fragment1(int n) {
        int sum         = 0;
        long startTime  = System.currentTimeMillis();
        for( int i = 0; i < n; i++ ) {
            sum++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Fragment 1: " +(endTime - startTime) + " milliseconds");
    }
}
