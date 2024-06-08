import java.util.ArrayList;

public class Contact {
    private static ArrayList<Contact> contacts;
    private ArrayList<Message> messages;
    private String name;
    private String address;
    private String phoneNumber;

    public Contact(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        if(contacts == null){
            contacts = new ArrayList<>();
        }
        messages = new ArrayList<>();
        contacts.add(this);
    }

    public String getDetails(){
        return "Name: " + this.name +"\nNumber: "+this.phoneNumber+"\nAddress: "+address;
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setContacts(ArrayList<Contact> contacts) {
        Contact.contacts = contacts;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return String.format("Contact: Name = %s; Address = %s; phoneNumber = %d\n", this.name,this.address,this.phoneNumber);
    }

}
