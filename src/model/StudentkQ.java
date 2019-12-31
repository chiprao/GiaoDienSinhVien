package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentkQ implements Serializable {

    private int stt;
    private int id;
    private String ten;
    private int tuoi;
    private String ngaysinh;
    private String gioitinh;
    private String lop;
    private String diachi;
    private String gk;
    private String ck;
    private String tk;
    private String xl;

    public StudentkQ() {
        super();
    }

    public StudentkQ(int stt, int id, String ten, int tuoi, Date day, String gioitinh, String lop, String diachi, String gk, String ck, String tk, String xl) {
        super();
        this.stt = stt;
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.ngaysinh = dt1.format(day);
        this.gioitinh = gioitinh;
        this.lop = lop;
        this.diachi = diachi;
        this.gk = gk;
        this.ck = ck;
        this.tk = tk;
        this.xl = xl;
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
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
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

    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }
}
