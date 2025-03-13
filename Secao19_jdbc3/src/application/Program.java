package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.DB;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Connection conn = null;
		PreparedStatement st = null;
		try {

			conn = DB.getConnection();

			st = conn.prepareStatement("INSERT INTO seller" + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES" + "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			// Converter a data corretamente
			LocalDate date = LocalDate.parse("22/04/1985", dtf);
			Date sqlDate = Date.valueOf(date);
			st.setDate(3, sqlDate);

			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				
			} else {
				System.out.println("No row affected!");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
