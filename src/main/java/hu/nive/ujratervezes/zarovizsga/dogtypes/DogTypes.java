package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) throws IllegalStateException {
        String query = "SELECT `name`  FROM `dog_types` WHERE `country` = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, country.toUpperCase());
            return getDogsByStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect or query", sqle);
        }
    }

    private List<String> getDogsByStatement(PreparedStatement stmt) throws IllegalStateException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot find dog", sqle);
        }
    }
}
