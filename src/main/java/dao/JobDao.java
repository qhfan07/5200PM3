package dao;

import model.*;
import java.sql.*;

public class JobDao {
    protected ConnectionManager connectionManager;
    private static JobDao instance = null;

    protected JobDao() {
        connectionManager = new ConnectionManager();
    }

    public static JobDao getInstance() {
        if(instance == null) {
            instance = new JobDao();
        }
        return instance;
    }

    public Job create(Job job) throws SQLException {
        String insertJob = "INSERT INTO Job(jobName, category, levelCap) VALUES(?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertJob, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, job.getJobName());
            insertStmt.setString(2, job.getCategory());
            insertStmt.setInt(3, job.getLevelCap());
            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int jobID = -1;
            if(resultKey.next()) {
                jobID = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            job.setJobID(jobID);
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) connection.close();
            if(insertStmt != null) insertStmt.close();
            if(resultKey != null) resultKey.close();
        }
    }

    public Job getJobByID(int jobID) throws SQLException {
        String selectJob = "SELECT jobID, jobName, category, levelCap FROM Job WHERE jobID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectJob);
            selectStmt.setInt(1, jobID);
            results = selectStmt.executeQuery();
            if(results.next()) {
                int resultJobID = results.getInt("jobID");
                String jobName = results.getString("jobName");
                String category = results.getString("category");
                int levelCap = results.getInt("levelCap");
                return new Job(resultJobID, jobName, category, levelCap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) connection.close();
            if(selectStmt != null) selectStmt.close();
            if(results != null) results.close();
        }
        return null;
    }
}
