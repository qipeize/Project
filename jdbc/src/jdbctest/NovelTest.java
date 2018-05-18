package jdbctest;

import java.io.IOException;
import java.sql.SQLException;

public class NovelTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		ReadAddWriteNovel raw = new ReadAddWriteNovel();
	//	raw.ReaderNovel();
		raw.WriteNovel();
	}
}
