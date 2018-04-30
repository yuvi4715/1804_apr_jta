package dao;

import java.util.List;

public interface RequestDao {
	public boolean insertRequest(Request Request);
	public List<Request> getRequest(int id);
	public List<Request> getAllRequests();
	public List<Request> getResolvedRequests();
	public List<Request> getUnresolvedRequests();
	public boolean approveRequest(int reqId, int id);
	public boolean updateRequest(Request req);
	public boolean denyRequest(int x, int empId);
}
