/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author duchi
 */
public class ketnoi {
    Connection conn=null;
    public ketnoi() throws SQLException{
        String url="jdbc:mysql://localhost:3306/qlgiangvien";
        this.conn=DriverManager.getConnection(url,"root","");
    }
    
    public ResultSet LayDL(String tbname) throws SQLException{
        ResultSet rs =null;
        Statement ts= this.conn.createStatement();
        String sql="select * from "+tbname; /*ORDER BY `Luong` ASC*/
        rs=ts.executeQuery(sql);
        return rs;
    }
    public ResultSet LayDL2(String tbname) throws SQLException{
        ResultSet rs =null;
        Statement ts= this.conn.createStatement();
        String sql="select * from "+tbname;/*ORDER BY `Luong` DESC*/
        rs=ts.executeQuery(sql);
        return rs;
    }
    public void UpdateCH(String ten, String email, String diachi, String sdt, int sgiod, int luong,int sogioqd) throws SQLException { 
        Statement sta = this.conn.createStatement();
        String sql0="UPDATE gvch SET `Email`='" + email + "',`DiaChi`='" + diachi + "',`SDT`='" + sdt +"',`SGDay`='" + sgiod +"',`Luong`='" + luong +"',`SoGioQD`='" + sogioqd +"' WHERE `TenGV`='"+ ten + "'";
        sta.executeUpdate(sql0);
    }

    public void InsertCH(String ten, String email, String diachi, String sdt, int sgiod, int luong,int sogioqd) throws SQLException { 
        Statement sta = this.conn.createStatement(); 
        String sql1 = "Insert gvch values('"+ten+"','"+email+"','"+diachi+"','"+sdt+"','"+sgiod+"','"+luong+"','"+sogioqd+"')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String ma) throws SQLException {

        Statement sta = this.conn.createStatement();
        String sql = "Delete from gvch WHERE `TenGV`='"+ ma +"'";
        sta.executeUpdate(sql);
    }
    public ResultSet Timkiem(String ma) throws SQLException{
         ResultSet rs = null;
        Statement sta =this.conn.createStatement();
          String sql = "select * from gvch where `TenGV` ='" + ma + "'";
        rs=sta.executeQuery(sql);
        return rs;        
    }
    
    
    public void UpdateTG(String ten, String email, String diachi, String sdt, String coquan, int sogiogd) throws SQLException { 
        Statement sta = this.conn.createStatement();
        int a=200000;
        int luong=sogiogd*a;
        String sql0="UPDATE gvtg SET `Email`='" + email + "',`DiaChi`='" + diachi + "',`SDT`='" + sdt +"',`CoQuan`='" + coquan +"',`SoGioGD`='" + sogiogd +"',`Luong`='" + luong +"' WHERE `TenGV`='"+ ten + "'";
        sta.executeUpdate(sql0);
    }

    public void InsertTG(String ten, String email, String diachi, String sdt, String coquan, int sogiogd) throws SQLException { 
        Statement sta = this.conn.createStatement();
        int a=200000;
        int luong=sogiogd*a;
        String sql1 = "Insert gvtg values('"+ten+"','"+email+"','"+diachi+"','"+sdt+"','"+coquan+"','"+sogiogd+"','"+luong+"')";
        sta.executeUpdate(sql1);
    }
    public void DeleteTG(String ma) throws SQLException {

        Statement sta = this.conn.createStatement();
        String sql = "Delete from gvtg WHERE `TenGV`='"+ ma +"'";
        sta.executeUpdate(sql);
    }
    public ResultSet TimkiemTG(String ma) throws SQLException{
         ResultSet rs = null;
        Statement sta =this.conn.createStatement();
          String sql = "select * from gvtg where `TenGV` ='" + ma + "'";
        rs=sta.executeQuery(sql);
        return rs;        
    }
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ketnoi kn = new ketnoi();
        ResultSet rs = kn.LayDL("gvch");
        while(rs.next())
            {
                System.out.println(rs.getString(1)+" - "+ rs.getString(2)+" - "+
                    rs.getString(3)+" - "+ rs.getString(4)+" - "+ rs.getString(5)+" - "+ 
                    rs.getString(6)+" - "+ rs.getString(7));
            }
    } 
}
