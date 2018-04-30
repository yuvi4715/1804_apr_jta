package ersProject1;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.revature.beans.Request;
import com.revature.service.RequestService;

class RequestServiceTest {

	@Test
	public void insertRequestTest() {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Request request = new Request(2,500.00,2,1,"Pending","Travel",ts,ts);
		assertTrue(RequestService.insertIntoRequest(request));
	}
	
	@Test
	public void updateReviewedTest() {
		int requestId = 1, reviewedBy=1;
		String statusOfRequest = "Denied";
		assertTrue(RequestService.updateReviewed(requestId, statusOfRequest, reviewedBy));
	}
	
	@Test
	public void updateStatusOfRequestTest() {
		int requestId = 1;
		String status = "Approved";
		assertTrue(RequestService.updateStatusOfRequest(requestId, status));
	}
	
	@Test
	public void getRequestsByReqeusterUsernameTest() {
		String username = "Tester";
		List<Request> lr = RequestService.getRequestsByRequesterUsername(username);
		assertNotNull(lr);
	}
	
	@Test
	public void getAllRequestsTest() {
		List<Request> lr = RequestService.getAllRequests();
		assertNotNull(lr);
	}
	
	@Test
	public void getAllPendingRequestsTest() {
		List<Request> lr = RequestService.getAllPendingRequests();
		assertNotNull(lr);
	}
	
	@Test
	public void getAllApprovedRequestsTest() {
		List<Request> lr = RequestService.getAllApprovedRequests();
		assertNotNull(lr);
	}
	
	@Test
	public void getAllDeniedRequestsTest() {
		List<Request> lr = RequestService.getAllDeniedRequests();
		assertNotNull(lr);
	}
	
	@Test
	public void updateRequestTest() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Request request = new Request(2,500.00,2,1,"Pending","Travel",ts,ts);
		assertTrue(RequestService.updateRequest(request));
	}
	
	@Test
	public void getRequestByReviewerUsernameTest() {
		String username = "Tester";
		List<Request> lr = RequestService.getRequestsByReviewerUsername(username);
		assertNotNull(lr);
	}

}
