package Data;

import model.Student;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteFileXML {
    public static void wrieData(List<Student> list) throws IOException {
        List<Student> temp = list;
        FileOutputStream fos = new FileOutputStream(new File("./student.xml"));
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(temp);
        encoder.close();
        fos.close();
    }
}