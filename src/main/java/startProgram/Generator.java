package startProgram;

import xmlGenerators.XMLFileForGroup;
import xmlGenerators.XMLFileForPerson;

import java.util.Scanner;

public class Generator {
    public void start() {
        System.out.println("Какие данные будем генерировать? \n Для генерации данных 1 контакта введите - контакт \n " +
                "для генерации группы контактов введите - группа");
        Scanner scan = new Scanner(System.in);
        String scanner = scan.nextLine();
        switch (scanner){
            case "контакт":
                XMLFileForPerson onePerson = new XMLFileForPerson();
                onePerson.writeXMLFile();
                break;
            case "группа":
                System.out.println("Какое число пользователей должна содержать группа?");
                scan = new Scanner(System.in);
                int numberPersons = scan.nextInt();
                XMLFileForGroup groupPersons = new XMLFileForGroup();
                groupPersons.writeXmlFile(numberPersons);
                break;
        }
    }
}
