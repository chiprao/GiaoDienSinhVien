package Data;


import model.Student;
import model.User;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileXML {
    public static List<User> readListUser() throws IOException {
        List<User> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("./user.xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        list = (List<User>) decoder.readObject();
        decoder.close();
        fis.close();
        return list;
    }

    public static List<Student> readListStudent() throws IOException {
        List<Student> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("E:\\JaVa\\GiaoDienSinhVien\\student .xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        list = (List<Student>) decoder.readObject();
        decoder.close();
        fis.close();
        return list;
    }
}