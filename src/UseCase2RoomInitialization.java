public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization");

        SingleRoom single = new SingleRoom();
        DoubleRoom dbl = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        System.out.println("\nSingle Room:");
        single.displayRoomDetails();

        System.out.println("\nDouble Room:");
        dbl.displayRoomDetails();

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
    }
}