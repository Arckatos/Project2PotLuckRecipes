package dataaccesslayer;
import java.util.List;

import transferobjects.Member;

/**
 * <h3>Interface: MembersDao.java</h3>
 * <h4>Description:</h4> 
 * MembersDao is the interface for the MembersDaoImpl class.   
 *
 * @author    Filipe Botelho
 * @version   1.0.0 Nov 29, 2015
 */
public interface MembersDao {
	/**
	 * getAllTasks will be used to retrieve a list of all tasks
	 *	@return	List <ul><li>Will return a list of Task objects.</ul>
	 */	
	public List<Member> getAllMembers();
	/**
	 * getMemberById(int memberId) will be used to retrieve a single member by id.
	 * @param memberId <ul><li> will receive a numerical value.</ul>
	 * @return member <ul><li> Will return a Member object.</ul>
	 */
	public Member getMemberById(int memberId);
	/**
	 * addMember(Member member) will be used to add a member.
	 * @param member <ul><li> Will receive a Member object.</ul>
	 */
	public void addMember(Member member);
	/**
	 * updateMember(Member member) will be used to update a member.
	 * @param member <ul><li> Will receive a Member object.</ul>
	 */
	public void updateMember(Member member);
	/**
	 * deleteMember(Member member) will be used to delete a member.
	 * @param member <ul><li> Will receive a Member object.</ul>
	 */
	public void deleteMember(Member member);
}
