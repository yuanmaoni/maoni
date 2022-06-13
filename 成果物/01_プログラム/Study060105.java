package study0601;

/*==============================*
 * 
 * 
 * 
 *=============================*/
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
 * CSVファイルを読み込み、DBに登録する
 * 
 * @author c
 * @version 1.0.0
 */
public class Study060105 {

	public static void main(String[] args) throws SecurityException, IOException {
		/**
		 * ログの初期処理 ログレベル設定
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
			logger.info("処理を開始しました。");
			// JDBCドライバをロード
			Class.forName("org.postgresql.Driver");
			// DBに接続
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"root");
			// コネクションの取得
			Statement stmt = conn.createStatement();

			// CSVファイルを読み込みする
			try {
				File f = new File("C:\\Users\\compu\\Desktop\\infile.csv");
				BufferedReader br = new BufferedReader(new FileReader(f));
				int countNum = 0;
				String line;
				// SQLの実行
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",", 0);
					countNum++;
					stmt.executeUpdate("INSERT INTO outfile(pid,picname,rid,pictxt,ord) VALUES (" + data[0] + ","
							+ data[1] + "," + data[2] + "," + data[3] + "," + data[4] + ");");
				}
				logger.info(countNum+"件データが読み取りました。");
				br.close();
				logger.info("正常に終了しました。");
			} catch (IOException e) {
				logger.log(Level.SEVERE, "ファイルの読み取りに失敗しました", e);
			}
			// ステートメントとコレクションのclose
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, "エラーが発生しました。", e);
			System.out.println(e);
		}
	}

}
