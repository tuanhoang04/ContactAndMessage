import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int id = 0;

    public static void main(String[] args) {
        showInitialOptions();
    }

    private static void showInitialOptions() {
        boolean con = true;
        while (con) {
            System.out.print("Hello, please choose one of these options:\n" +
                    "1. Manage contacts\n" +
                    "2. Messages\n" +
                    "3. Quit\n" +
                    "Your choice: ");
            int a = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (a) {
                case 1:
                    manageContacts();
                    break;
                case 2:
                    manageMessages();
                    break;
                case 3:
                    con = false;
            }
        }
    }

    private static void manageContacts() {
        boolean con1 = true;
        while(con1){
            System.out.println("Choose one of these options: \n" +
                    "1.Show all contacts\n" +
                    "2.Add a new contact\n" +
                    "3.Search for a contact\n" +
                    "4.Delete a contact\n" +
                    "5.Go back to the previous menu");
            System.out.print("Your choice: ");
            int sw1 = sc.nextInt();
            sc.nextLine();
            switch(sw1){
                case 2:
                    addNewContact();
                    break;
                case 5:
                    con1 = false;
                    break;
                case 1:
                    showAllContacts();
                    break;
                case 3:
                    searchForContact();
                    break;
                case 4:
                    deleteContact();
                    break;
            }
        }
    }

    private static void manageMessages() {
        boolean con2 = true;
        while(con2) {
            System.out.println("Choose one of these options: \n" +
                    "1.See the list of all messages\n" +
                    "2.Send a new message\n" +
                    "3.Go back to the previous menu");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    showAllMessages();
                    break;
                case 2:
                    sendNewMessage();
                case 3:
                    con2 = false;
                    break;
            }
        }
    }

    private static void sendNewMessage() {
        System.out.println("What is the recipient's name?");
        String name = sc.nextLine();
        boolean doesExist = false;
        for(Contact a : Contact.getContacts()){
            if(a.getName().equals(name)){
                doesExist = true;
                break;
            }
        }
        if(doesExist){
            System.out.println("Type in the message: ");
            String text = sc.nextLine();
            id++;
            Message newMessage = new Message(text, name, id);
            for(Contact a: Contact.getContacts()){
                if(a.getName().equals(name)){
                    a.getMessages().add(newMessage);
                }
            }
        }else{
            System.out.println("No such contact name exists!");
        }
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for(Contact a : Contact.getContacts()){
            allMessages.addAll(a.getMessages());
        }
        if(!allMessages.isEmpty()){
            System.out.println("***************");
            for(Message a : allMessages){
                System.out.println(a.getDetails());
                System.out.println("***************");
            }
        }else{
            System.out.println("No message found!");
        }
    }

    private static void addNewContact(){
        System.out.print("Please enter the name: ");
        String name = sc.nextLine();
        System.out.print("Please enter the address: ");
        String address = sc.nextLine();
        System.out.print("Please enter the phone number: ");
        String phone = sc.nextLine();
        Contact newContact = new Contact(name,address,phone);
        System.out.println("Added contact successfully!\n");
    }
    private static void showAllContacts() {
        System.out.println("***************");
        for(Contact a : Contact.getContacts()){
            System.out.println(a.getDetails());
            System.out.println("***************");
        }
    }

    private static void searchForContact() {
        System.out.print("Type in the name of the contact you want to search: ");
        String str1 = sc.nextLine();
        boolean doesExist = false;
        for(Contact a: Contact.getContacts()){
            if(a.getName().equals(str1)){
                System.out.println(a.getDetails());
                doesExist = true;
            }
        }
        if(!doesExist){
            System.out.println("The name of the contact you typed in does not exist!");
        }
    }

    private static void deleteContact() {
        System.out.print("Type in the name of the contact you want to delete: ");
        String str1 = sc.nextLine();
        boolean doesExist = false;
        for(Contact a: Contact.getContacts()){
            if(a.getName().equals(str1)){
                System.out.println("Contact "+ a.getName()+" was deleted successfully!");
                Contact.getContacts().remove(a);
                doesExist = true;
            }
        }
        if(!doesExist){
            System.out.println("The name of the contact you typed in does not exist!");
        }
    }
}