package jp.co.f1.jdbc.ch03;

import java.sql.*;

//資料
//https://kanda-it-school-kensyu.com/java-jdbc-contents/jj_ch03/jj_0301/

public class SampleTransaction {

	//接続用の情報をフィールドに定数として定義
	private static String RDB_DRIVE="com.mysql.cj.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/hwm";
 	private static String USER="root";
 	private static String PASSWD="root";

 	public static void main(String[] args) {

 		String sql = null;
 		int num = 0 ;

 		Connection con = null;
 		Statement smt = null;

		System.out.println("\n登録処理は開始しました。");
 		try {
 			Class.forName(RDB_DRIVE);
 			con = DriverManager.getConnection(URL,USER,PASSWD);

 			con.setAutoCommit(false);

 			smt = con.createStatement();

 			sql = "INSERT INTO bookinfo (isbn, title, price) VALUES('00006', 'Object-C入門テキスト', 3500)";
 			num = smt.executeUpdate(sql);

 			sql = "INSERT INTO bookinfo (isbn, title, price) VALUES('00007', 'C++入門テキスト', 3000)";
 			num = smt.executeUpdate(sql);

 			System.out.println("\n2件の新規レコードを登録しました。");

 			System.out.println("\n書籍一覧表示");
 			selectAll();

 			System.out.println("\nコミット処理を実施しました。");
 			con.commit();

 			System.out.println("\n●コミット後の書籍一覧表示");
 			selectAll();
 			System.out.println("\n登録処理は正常終了しました。");

 		} catch (Exception e) {
 			System.out.println("データベースエラー：" + e);
 			if (con != null) {
 				try {
 					System.out.println("\nロールバック処理を実施しました。");
 					con.rollback();
 		 			System.out.println("\n登録処理は異常終了しました。");

 		 			System.out.println("\nロールバック後の書籍一覧表示");
 		 			selectAll();
 				} catch (SQLException ignore) {
 					//例外処理の無視
 				}
 			}
 		} finally {
 			try {
 				if (smt != null) {
 					smt.close();
 				}
 				if (con != null) {
 					con.close();
 				}
 			} catch (SQLException ignore) {
 				//例外処理の無視
 			}
 		}
 	}

 	private static void selectAll()	{

 		Connection con = null;
 		Statement  smt = null;

 		try{
 			Class.forName(RDB_DRIVE);
 			con = DriverManager.getConnection(URL,USER,PASSWD);

 			smt = con.createStatement();

 			//データベースへ発行するSQL文
 			String sql = "SELECT * FROM bookinfo";

 			ResultSet rs = smt.executeQuery(sql);

 			while (rs.next()) {
 				System.out.println("isbn ： "   + rs.getString("isbn") +
 						"\t title ： " + rs.getString("title") +
 						"\t price： "  + rs.getInt("price"));
 			}

 		}catch (Exception e) {
 			System.out.println("JDBCデータベース接続エラー");

  		}finally{
  			try {
  				if (smt != null) {
  					smt.close();
  				}
  				if (con != null) {
  					con.close();
  				}

  			} catch (SQLException ignore) {
  				//例外処理の無視
  			}
  		}
  	}
  }