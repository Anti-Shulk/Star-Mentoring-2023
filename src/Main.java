import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final float TRACK_WIDTH_MIN = 4;
        final float TRACK_WIDTH_MAX = 12;
        final float VELOCITY_MIN = -100;
        final float VELOCITY_MAX = 100;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the track width of the robot");
        System.out.print("between " + TRACK_WIDTH_MIN + " and " + TRACK_WIDTH_MAX + " inches: ");
        float trackWidth = 0;

        while (true) {
            trackWidth = getFloat();

            if (trackWidth > TRACK_WIDTH_MAX || trackWidth < TRACK_WIDTH_MIN) {
                System.out.println("Track width was not between " + 
                TRACK_WIDTH_MIN + " and " + TRACK_WIDTH_MAX + " inches");
                System.out.print("Please reenter the input: ");
                continue;
            }
            break;
        }

        System.out.println("Please enter the velocity of the Front Left Wheel");
        System.out.print("between " + VELOCITY_MIN + " and " + VELOCITY_MAX + " inches per second: ");
        float frontLeftVelocity = getVelocityInchesPerSecond();

        System.out.println("Please enter the velocity of the Front Right Wheel");
        System.out.print("between " + VELOCITY_MIN + " and " + VELOCITY_MAX + " inches per second: ");
        float frontRightVelocity = getVelocityInchesPerSecond();

        System.out.println("Please enter the velocity of the Back Left Wheel");
        System.out.print("between " + VELOCITY_MIN + " and " + VELOCITY_MAX + " inches per second: ");
        float backLeftVelocity = getVelocityInchesPerSecond();

        System.out.println("Please enter the velocity of the Back Right Wheel");
        System.out.print("between " + VELOCITY_MIN + " and " + VELOCITY_MAX + " inches per second: ");
        float backRightVelocity = getVelocityInchesPerSecond();

        float angularVelocityRadians = (backRightVelocity + frontRightVelocity - frontLeftVelocity - backLeftVelocity) /
                                        (4 * trackWidth);
        
        float angularVelocityDegrees = (float) Math.toDegrees(angularVelocityRadians);

        System.out.println("The angular velocity is " + angularVelocityDegrees + " degrees per second");

        scanner.close();
    }

    static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;

        while (true) {
            String input = scanner.nextLine().trim();
            try {
                number = Float.parseFloat(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Input was not a valid floating point number");
                System.out.print("Please reenter the input: ");
                continue;
            }
            break;
        }

        return number;
    }

    static float getVelocityInchesPerSecond() {
        final float VELOCITY_MIN = -100;
        final float VELOCITY_MAX = 100;

        float velocity = 0;

        while (true) {
            velocity = getFloat();
            if (velocity > VELOCITY_MAX || velocity < VELOCITY_MIN) {
                System.out.println("Velocity was not between " + 
                VELOCITY_MIN + " and " + VELOCITY_MAX + " inches");
                System.out.print("Please reenter the input: ");
                continue;
            }
            break;
        }
        return velocity;
    }
}