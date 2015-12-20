package com.keystoneexamprep.model.dao.jdbc;

import com.keystoneexamprep.model.dao.IKeystoneExamPrepDao;
import com.keystoneexamprep.model.domain.Student;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * This is where the JDBC Code goes into.
 */

public class KeystoneExamPrepJDBCDaoImpl implements IKeystoneExamPrepDao
{
    static Logger log = Logger.getLogger("com.fleetrentaljdbcdaosample");
    
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;

    /**
    * @param jdbcUrl the jdbcUrl to set
    */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
    * @param jdbcUser the jdbcUser to set
    */
    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    /**
    * @param jdbcPassword the jdbcPassword to set
    */
    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }    
    
    /**
    * Using the connection parameters from the property files, loads and
    * registers the JDBC driver and gets the database connection and returns in.
    *
    * @return Connection Connection returned on success otherwise returns null
    * @throws SQLException
    */
    private Connection fetchConnection()
    {
        log.info ("Fetching Database Connection");

        Connection conn = null;
        

        //load and register JDBC driver then connect to database
        try
        {
            DriverManager.registerDriver( new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            log.debug("JDBC driver successfully connected");
        }
        catch (SQLException e)
        {
            log.error("Could not load and register JDBC driver or connect to database.");         
            log.error  (e.getClass()+": "+ e.getMessage(), e);         
        }
        return conn;
    } //end fetchConnection
    
    /**
     * Retrieve all the vehicles that are available based on
    * criteria in the Itinerary object and populate AvailableRentals
     * @param studentToSave
     * @return boolean true if rentals are available, else false
     */
    @Override
    public boolean registerAcct(Student studentToSave)
    {
        boolean status = false;

        log.info("-------------------------------");
        log.info("Using JDBC Implementation");
        log.info("-------------------------------");

        log.info ("Inside KeystoneExamPrepJDBCDaoImpl - registerAcct");
        
        String lastNameVar = studentToSave.getLastName();
        String firstNameVar = studentToSave.getFirstName();
        String birthMonthVar = studentToSave.getBirthMonth();
        byte birthDateVar = studentToSave.getBirthDate();
        short birthYearVar = studentToSave.getBirthYear();
        String emailAddressVar = studentToSave.getEmailAddress();
        char[] passwordCharVar = studentToSave.getPassword();
        String passwordVar="";
        for(int i = 0; i<passwordCharVar.length; i++)
            passwordVar+=passwordCharVar[i];
        String phoneNumberVar = studentToSave.getPhoneNumber();

        Connection conn = null;
        Statement stmt  = null;
        
        try
        {
            // Create a connection
            conn = fetchConnection();
            stmt = conn.createStatement();
            
            //String sql = "INSERT INTO student(lastName, firstName, birthMonth, birthDate, birthYear, emailAddress, password, phoneNumber) VALUES (@lastNameVar, @firstNameVar, @birthMonthVar, @birthDateVar, @birthYearVar, '%s', NULL, @phoneNumberVar)";
            String sql = "INSERT INTO student(lastName, firstName, birthMonth, birthDate, birthYear, emailAddress, password, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            //String sql = "INSERT INTO testtable(name, address1, address2,phone, email)VALUES(?,?,?,?,?)"
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,lastNameVar);
            statement.setString(2,firstNameVar);
            statement.setString(3,birthMonthVar);
            statement.setByte(4,birthDateVar);
            statement.setShort(5,birthYearVar);
            statement.setString(6,emailAddressVar);
            statement.setString(7,passwordVar);
            statement.setString(8,phoneNumberVar);
            statement.executeUpdate();
            //stmt.executeUpdate(sql);
            status = true;
        }
        catch(SQLException e)
	{
            log.error  (e.getClass()+": "+ e.getMessage(), e);
	}
	finally //must close resources in finally block
        {
            try 
            {
                // check for null first before closing resources
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                conn.close();
                }												
            }
            catch (SQLException e)
            {										
              log.error  (e.getClass()+": "+ e.getMessage(), e);									
            } 
        }	
        return status;
    } //end registerAcct

    /**
     * Checks the database for the username and password the username entered for a match
     * @param email
     * @param password
     * @return true if there is a match, false if not.
     */
    @Override
    public boolean authenticateAcct(String email, char[] password)
    {
        boolean status = false;

        log.info("-------------------------------");
        log.info("Using JDBC Implementation");
        log.info("-------------------------------");

        log.info ("Inside KeystoneExamPrepJDBCDaoImpl - authenticateAcct");

        Connection conn = null;
        Statement stmt  = null;
        PreparedStatement selectUsername;
        
        try
        {
            // Create a connection
            conn = fetchConnection();
            stmt = conn.createStatement();
            String emailAddressVar = email;
            String passwordVar = "";
            for(int i = 0; i<password.length; i++)
                passwordVar+=password[i];
            
            selectUsername = conn.prepareStatement("SELECT emailAddress, password FROM student WHERE (emailAddress = ?) AND (password = ?)");
            //selectUsername = conn.prepareStatement("SELECT emailAddress, password FROM student WHERE emailAddress = ?");
            
            selectUsername.setString(1, email);
            selectUsername.setString(2, passwordVar);
            
            ResultSet resultSet = selectUsername.executeQuery();
            
            boolean val = resultSet.next(); //next() returns false if there are no-rows retrieved 
            if(val==false){
                log.debug("Acct not Authenticated");
                status = false;
            }
            else
            {
                log.debug("Acct Authenticated");
                status = true;
            }
            
        }
        catch(SQLException e)
	{
            log.error  (e.getClass()+": "+ e.getMessage(), e);
	}
	finally //must close resources in finally block
        {
            try 
            {
                // check for null first before closing resources
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                conn.close();
                }												
            }
            catch (SQLException e)
            {										
              log.error  (e.getClass()+": "+ e.getMessage(), e);									
            } 
        }	
        return status;
    } //end authenticateAcct
    
} // end class KeystoneExamPrepJDBCDaoImpl
