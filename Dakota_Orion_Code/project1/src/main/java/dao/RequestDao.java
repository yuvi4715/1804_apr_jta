package dao;

import java.util.List;

public interface RequestDao {
	public boolean insertRequest(Request Request);
	public Request getRequest(int id);
	public List<Request> getAllRequests();
	public boolean updateRequest(Request Request);
	public List<Request> getResolvedRequests();
	public List<Request> getUnresolvedRequests();
}
