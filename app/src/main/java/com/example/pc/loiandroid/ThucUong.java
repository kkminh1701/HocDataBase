package com.example.pc.loiandroid;



public class ThucUong {
//    public int id;
    public String ten;
    public String note;

    public ThucUong(String ten, String note) {
        this.ten = ten;
        this.note = note;
    }
     public byte [] anh;

    public ThucUong( String ten, String note, byte[] anh) {
        //this.id = id;
        this.ten = ten;
        this.note = note;
        this.anh = anh;
    }
}
