package model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private int stt;
    private int id;
    private String Ten;
    private int tuoi;
    private Date ngaysinh;
    private String gioitinh;
    private String lop;
    private String diachi;


    public Student() {
    }

    public Student(int stt, int id, String ten, int tuoi, String gioitinh, String lop, String diachi,  Date ngaysinh) {
        super();
        this.stt = stt;
        this.id = id;
        Ten = ten;
        this.tuoi = tuoi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.lop = lop;
        this.diachi = diachi;
    }


    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
