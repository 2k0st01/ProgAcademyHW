package homework1afis;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Phone phone1 = new Phone("1");
        Phone phone2 = new Phone("2");
        Phone phone3 = new Phone("3");

        network.registerInNetwork(phone1);
        network.registerInNetwork(phone2);

        phone1.outgoingCall("2");
        phone1.outgoingCall("3");

    }
}
