package jp.co.f1.jdbc.ch03;

import java.sql.*;

//����
//https://kanda-it-school-kensyu.com/java-jdbc-contents/jj_ch03/jj_0301/

public class SampleTransaction {

	//�ڑ��p�̏����t�B�[���h�ɒ萔�Ƃ��Ē�`
	private static String RDB_DRIVE="com.mysql.cj.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/hwm";
 	private static String USER="root";
 	private static String PASSWD="root";

 	public static void main(String[] args) {

 		String sql = null;
 		int num = 0 ;

 		Connection con = null;
 		Statement smt = null;

		System.out.println("\n�o�^�����͊J�n���܂����B");
 		try {
 			Class.forName(RDB_DRIVE);
 			con = DriverManager.getConnection(URL,USER,PASSWD);

 			con.setAutoCommit(false);

 			smt = con.createStatement();

 			sql = "INSERT INTO bookinfo (isbn, title, price) VALUES('00006', 'Object-C����e�L�X�g', 3500)";
 			num = smt.executeUpdate(sql);

 			sql = "INSERT INTO bookinfo (isbn, title, price) VALUES('00007', 'C++����e�L�X�g', 3000)";
 			num = smt.executeUpdate(sql);

 			System.out.println("\n2���̐V�K���R�[�h��o�^���܂����B");

 			System.out.println("\n���Јꗗ�\��");
 			selectAll();

 			System.out.println("\n�R�~�b�g���������{���܂����B");
 			con.commit();

 			System.out.println("\n���R�~�b�g��̏��Јꗗ�\��");
 			selectAll();
 			System.out.println("\n�o�^�����͐���I�����܂����B");

 		} catch (Exception e) {
 			System.out.println("�f�[�^�x�[�X�G���[�F" + e);
 			if (con != null) {
 				try {
 					System.out.println("\n���[���o�b�N���������{���܂����B");
 					con.rollback();
 		 			System.out.println("\n�o�^�����ُ͈�I�����܂����B");

 		 			System.out.println("\n���[���o�b�N��̏��Јꗗ�\��");
 		 			selectAll();
 				} catch (SQLException ignore) {
 					//��O�����̖���
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
 				//��O�����̖���
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

 			//�f�[�^�x�[�X�֔��s����SQL��
 			String sql = "SELECT * FROM bookinfo";

 			ResultSet rs = smt.executeQuery(sql);

 			while (rs.next()) {
 				System.out.println("isbn �F "   + rs.getString("isbn") +
 						"\t title �F " + rs.getString("title") +
 						"\t price�F "  + rs.getInt("price"));
 			}

 		}catch (Exception e) {
 			System.out.println("JDBC�f�[�^�x�[�X�ڑ��G���[");

  		}finally{
  			try {
  				if (smt != null) {
  					smt.close();
  				}
  				if (con != null) {
  					con.close();
  				}

  			} catch (SQLException ignore) {
  				//��O�����̖���
  			}
  		}
  	}
  }