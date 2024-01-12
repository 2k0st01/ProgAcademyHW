package homework1afis;

public class Phone {
    private String number;
    private Network network;

    public Phone(String number) {
        this.number = number;
    }

    public Phone() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void outgoingCall(String number) {
        if(network != null && network.checkNumber(this.number) != null){
            if(network.checkNumber(number) != null){
                Phone outcome = network.checkNumber(number);
                outcome.incomingCall(this.number);
            } else
                System.out.println( "The number you are trying to call is not registered on the network.");
        } else
            System.out.println( "Your number is not register in network.");
    }

    private void incomingCall(String number){
        System.out.println("Dear " + this.number + " the number is calling you: " + number);
    }

}
