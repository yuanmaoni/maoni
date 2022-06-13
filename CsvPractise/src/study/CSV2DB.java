package study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * CSV�t�@�C����ǂݍ��݁ADB�ɓo�^����
 *
 * @author c
 * @version 1.0.0
 */
public class CSV2DB {

	public static void main(String[] args) throws SecurityException, IOException {
		/**
		 * ���O�̏������� ���O���x���ݒ�
		 */
		Logger logger = Logger.getLogger("log-Test");
		logger.setLevel(Level.ALL);
		Date logDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmm");
		FileHandler fileHandler = new FileHandler("C:\\Users\\compu\\Desktop/Log"+dateFormat.format(logDate)+".log");
		logger.addHandler(fileHandler);
		fileHandler.setLevel(Level.ALL);
		Formatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);
		try {
			logger.info("�������J�n���܂����B");
			// JDBC�h���C�o�����[�h
			Class.forName("org.postgresql.Driver");
			// DB�ɐڑ�
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"root");
			// �R�l�N�V�����̎擾
			Statement stmt = conn.createStatement();

			// CSV�t�@�C����ǂݍ���
			try {
				File f = new File("infile.csv");
				BufferedReader br = new BufferedReader(new FileReader(f));
				int countNum = 0;
				String line;
				String strSql;
				// SQL�̎��s
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",", 0);
					countNum++;
					strSql="INSERT INTO outfile(pid,picname,rid,pictxt,ord) VALUES (" + data[0] + ","
							+ data[1] + "," + data[2] + "," + data[3] + "," + data[4] + ");";
//					strSql="INSERT INTO outfile(pid,picname,rid,pictxt,ord) VALUES (18,'cp',11,'20101011.jpg',1);";
					stmt.executeUpdate(strSql);
				}
				logger.info(countNum+"���f�[�^���ǂݎ��܂����B");
				br.close();
				logger.info("����ɏI�����܂����B");
			} catch (IOException e) {
				logger.log(Level.SEVERE, "�t�@�C���̓ǂݎ��Ɏ��s���܂���", e);
			}
			// �X�e�[�g�����g�ƃR���N�V������close
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "�G���[���������܂����B", e);
			System.out.println(e);
		}
	}

}