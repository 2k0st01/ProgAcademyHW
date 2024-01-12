package homework1afis;

public class Network {
    Phone[] phones = new Phone[10];

    public Network(Phone[] phones) {
        this.phones = phones;
    }

    public Network() {
    }

    public boolean registerInNetwork(Phone phone) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] == null) {
                phones[i] = phone;
                phone.setNetwork(this);
                return true;
            }
        }
        return false;
    }

    public Phone checkNumber(String number) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getNumber().equals(number)) {
                return phones[i];
            }
        }
        return null;
    }


}
