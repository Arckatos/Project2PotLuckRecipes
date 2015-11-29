package dataaccesslayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import transferobjects.Member;


/**
 * <h3>Class: TaskDaoImpl.java</h3>
 * <h4>Description:</h4> 
 * TaskDaoImpl.java is part of the DATA ACCESS OBJECT design pattern. 
 * It will be used to access data from the Task database and manipulate the data.   
 * 
 * Code in this file was based on lecture materials provided by Stanley Pieda(2015)personal communications
 * 
 * @author    Filipe Botelho
 * @version   1.0.0 Nov 18, 2015
 */
public class MembersDaoImpl implements MembersDao{

	/* (non-Javadoc)
	 * @see dataaccesslayer.MembersDao#getAllMembers()
	 */
	@Override
	public List<Member> getAllMembers() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Member> memberList = null;
		try{
			DataSource ds = new DataSource();
			connection = ds.createConnection();
			statement = connection.prepareStatement(
					"SELECT MemberId, IsAdmin, Alias, FirstName, LastName, Email, Username, Password, Salt FROM members ORDER BY MemberId");
			resultSet = statement.executeQuery();
			memberList = new ArrayList<Member>();
			while(resultSet.next()){
				Member singleMember = new Member();
				singleMember.setMemberId(new Integer(resultSet.getInt("MemberId")));
				singleMember.setIsAdmin(resultSet.getBoolean("IsAdmin"));
				singleMember.setAlias(resultSet.getString("Alias"));
				singleMember.setFirstName(resultSet.getString("FirstName"));
				singleMember.setLastName(resultSet.getString("LastName"));
				singleMember.setEmail(resultSet.getString("Email"));
                                singleMember.setUsername(resultSet.getString("Username"));
                                singleMember.setPassword(resultSet.getString("Password"));
                                singleMember.setSalt(resultSet.getString("Salt"));
				memberList.add(singleMember);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{ if(resultSet != null){ resultSet.close(); } }
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(statement != null){ statement.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
		}
		return memberList;
	}//end getAllMembers

	/* (non-Javadoc)
	 * @see dataaccesslayer.MembersDao#getMemberById(int)
	 */
	@Override
	public Member getMemberById(int memberId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Member singleMember = null;
		try{
			DataSource ds = new DataSource();
			connection = ds.createConnection();
			statement = connection.prepareStatement(
					"SELECT MemberId, IsAdmin, Alias, FirstName, LastName, Email, Username, Password, Salt FROM members WHERE MemberId = ?");
			statement.setInt(1,memberId );
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				singleMember = new Member();
				singleMember.setMemberId(new Integer(resultSet.getInt("MemberId")));
				singleMember.setIsAdmin(resultSet.getBoolean("IsAdmin"));
				singleMember.setAlias(resultSet.getString("Alias"));
				singleMember.setFirstName(resultSet.getString("FirstName"));
				singleMember.setLastName(resultSet.getString("LastName"));
				singleMember.setEmail(resultSet.getString("Email"));
                                singleMember.setUsername(resultSet.getString("Username"));
                                singleMember.setPassword(resultSet.getString("Password"));
                                singleMember.setSalt(resultSet.getString("Salt"));
				
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{ if(resultSet != null){ resultSet.close(); } }
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(statement != null){ statement.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
		}
		return singleMember;
	}//end getMemberById

	/* (non-Javadoc)
	 * @see dataaccesslayer.MembersDao#addMember(transferobjects.Member)
	 */
	@Override
	public void addMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			DataSource ds = new DataSource();
			connection = ds.createConnection();
			
			statement = connection.prepareStatement(
					"INSERT INTO members (IsAdmin, Alias, FirstName, LastName, Email, Username, Password, Salt) " +
			        "VALUES(?,?,?,?,?,?,?,?)");
			statement.setBoolean(1, member.getIsAdmin());
			statement.setString(2, member.getAlias());
			statement.setString(3, member.getFirstName());
			statement.setString(4, member.getLastName());
			statement.setString(5, member.getEmail());
                        statement.setString(6, member.getUsername());
                        statement.setString(7, member.getPassword());
                        statement.setString(8, member.getSalt());
			statement.executeUpdate();
                        
                        
                       
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			
			try{ if(statement != null){ statement.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
		}
	}//end addMember

	/* (non-Javadoc)
	 * @see dataaccesslayer.MembersDao#updateMember(transferobjects.Member)
	 */
	@Override
	public void updateMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			DataSource ds = new DataSource();
			connection = ds.createConnection();
			statement = connection.prepareStatement(
					"UPDATE Tasks SET IsAdmin=?, Alias=?, FirstName=?, LastName=?, Email=?, Username=?, Password=?, Salt=? WHERE TaskID = ?");
			statement.setBoolean(1, member.getIsAdmin());
			statement.setString(2, member.getAlias());
			statement.setString(3, member.getFirstName());
			statement.setString(4, member.getLastName());
			statement.setString(5, member.getEmail());
                        statement.setString(6, member.getUsername());
                        statement.setString(7, member.getPassword());
                        statement.setString(8, member.getSalt());
                        statement.setInt(9, member.getMemberId());
			statement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			
			try{ if(statement != null){ statement.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
		}
		
	}//end updateMember

	/* (non-Javadoc)
	 * @see toDoList.DataAccessLayer.TaskDao#deleteTask(toDoList.DataTransferObjects.Task)
	 */
	@Override
	public void deleteMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			DataSource ds = new DataSource();
			connection = ds.createConnection();
			statement = connection.prepareStatement(
					"DELETE FROM Tasks WHERE MemberId = ?");	
			statement.setInt(1, member.getMemberId());
			statement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			
			try{ if(statement != null){ statement.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException sqle){System.out.println(sqle.getMessage());}
		}
		
	}//end deleteMember

}//end MembersDaoImpl


