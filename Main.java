package SwapnaliLearnsJava.com;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("876 77 689");
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter actions : (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting down....");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }


    private static void addNewContact(){
        System.out.print("Enter name of the new contact: ");
        String newContactName = scanner.nextLine();
        System.out.print("Enter the phoneNumber: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName,newPhoneNumber);
        mobilePhone.addNewContact(newContact);
    }

    private static void updateContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact not found on file ");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.modifyContact(existingContact, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact not found on file ");
            return;
        }
        if(mobilePhone.removeContact(existingContact)) {
            System.out.println("Contact removed from the list");
        }else{
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact not found on file ");
            return;
        }
        System.out.println("Name: "+existingContact.getName()+
                           "\nPhone NO: "+existingContact.getPhoneNumber());

    }


    private static void startPhone(){
        System.out.println("Starting a phone .....");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts \n" +
                           "2 - to add a new contact \n" +
                           "3 - to update an existing contact \n" +
                           "4 - to remove an existing contact \n" +
                           "5 - to query if an existing contact exists \n" +
                           "6 - to print a list of available actions.");
        System.out.println("Choose your action : ");
    }
}
