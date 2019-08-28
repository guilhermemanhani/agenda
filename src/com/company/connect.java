package com.company;

import java.sql.*;

public class connect {
    public static void main(String[] args) {
//        createNewTable();
        connect app = new connect();
        app.selectAll();
//        app.insert("Guilherme");
    }

    private  Connection connect(){
        String url = "jdbc:sqlite:banco.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

//    private static void connect(){
//        String url = "jdbc:sqlite:banco.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (conn !=null){
//                    conn.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }

    public static void createNewTable(){
        String url = "jdbc:sqlite:banco.db";
        String sql = "Create table if not exists teste(nome text not null)";

        try(Connection conn = DriverManager.getConnection(url);
            Statement stat = conn.createStatement()){
            stat.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectAll(){
        String sql = "select * from teste";

        try (Connection conn = this.connect();
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery(sql)){

            while (result.next()){
                System.out.println(result.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(String nome){
        String sql = "insert into teste(nome) Values(?)";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,nome);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
