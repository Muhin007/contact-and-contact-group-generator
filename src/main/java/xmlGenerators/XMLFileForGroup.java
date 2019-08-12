package xmlGenerators;

import randomData.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import startProgram.Generator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLFileForGroup {
private Generator generator = new Generator();
    private RandomNameGroup randomNameGroup = new RandomNameGroup();
    private RandomFullName randomFullName = new RandomFullName();
    private RandomAddress randomAddress = new RandomAddress();
    private RandomNumberOfPhone randomNumberOfPhone = new RandomNumberOfPhone();
    private RandomGUID randomGUID = new RandomGUID();

    public void writeXmlFile(int numberOfPerson) {

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("Group");
            doc.appendChild(root);

            Element groupName = doc.createElement("groupName");
            try {
                groupName.appendChild(doc.createTextNode(randomNameGroup.printNameGroup()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            root.appendChild(groupName);
            for (int i = 0; i < numberOfPerson; i++) {
                boolean sex = new RandomSex().randomSex();
                Element person = doc.createElement("person");
                root.appendChild(person);

                Element fullName = doc.createElement("fullName");
                fullName.appendChild(doc.createTextNode(randomFullName.getFullName(sex)));
                person.appendChild(fullName);

                Element address = doc.createElement("address");
                address.appendChild(doc.createTextNode(randomAddress.getAddress()));
                person.appendChild(address);


                Element phoneNumber = doc.createElement("phoneNumber");
                phoneNumber.appendChild(doc.createTextNode(randomNumberOfPhone.getNumberOfPhone()));
                person.appendChild(phoneNumber);

                Element GUID = doc.createElement("GUID");
                GUID.appendChild(doc.createTextNode(String.valueOf(randomGUID.getGUID())));
                person.appendChild(GUID);
            }
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss") ;
            try {
                FileWriter fos = new FileWriter(dateFormat.format(date) + "_group_" + numberOfPerson + "_units.xml");
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (TransformerException ex) {
            System.out.println("Error outputting document");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
        System.out.println("Файл сгенерирован \n ______________________________________________ \n");
     generator.returnToMenu();
    }
}

