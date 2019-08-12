package startProgram;

import xmlGenerators.XMLFileForGroup;
import xmlGenerators.XMLFileForPerson;

import java.util.Scanner;

public class Generator {


    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Какие данные будем генерировать? \n Для генерации данных 1 контакта введите - contact \n " +
                "для генерации группы контактов введите - group");
        String scanner = scan.nextLine();
        switch (scanner) {
            case "contact":
                XMLFileForPerson onePerson = new XMLFileForPerson();
                onePerson.writeXMLFile();
                break;
            case "group":
                System.out.println("Какое число пользователей должна содержать группа?");
                scan = new Scanner(System.in);
                int numberPersons = scan.nextInt();
                XMLFileForGroup groupPersons = new XMLFileForGroup();
                groupPersons.writeXmlFile(numberPersons);
                break;
        }
    }

    public void returnToMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Будем еще генерировать данные? yes or no");
        String scanner = scan.nextLine();
        switch (scanner) {
            case "yes":
                start();
                break;
            case "нno":
                System.out.println("Спасибо за работу");
                System.exit(0);
                break;
        }
    }
}
