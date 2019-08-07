package by.training.edocuments.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hamcrest.Condition.Step;

import by.training.edocuments.bean.Subordination;
import by.training.edocuments.bean.comparator.SubordinationByDocTypeComparator;
import by.training.edocuments.bean.comparator.SubordinationByReceiverComparator;
import by.training.edocuments.bean.comparator.SubordinationBySenderComparator;

public class SubordinationViewAction extends Action{
	private static int STEP = 10;

	@Override
	public void executeGet(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		String employeeID = request.getParameter("employeeID");
		HttpSession session = request.getSession();
		int page = Integer.parseInt(request.getParameter("page"));
		
		List<Subordination> fullSubs = (List<Subordination>) session.getAttribute("fullSubs");
		List<Subordination> subs = null;
		
		String sortBy = request.getParameter("sort");
		if (fullSubs != null) {
			if (sortBy != null) {
				switch (sortBy) {
				case "receiver":
					fullSubs.sort(new SubordinationByReceiverComparator());
					break;
				case "sender":
					fullSubs.sort(new SubordinationBySenderComparator());
					break;
				case "docType":
					fullSubs.sort(new SubordinationByDocTypeComparator());
					break;
				default:
					break;
				}
			}
			
			int begin = STEP*(page - 1);			
			int end = STEP*page-1;
			subs = fullSubs.subList(Math.max(begin, 0), Math.min(end, fullSubs.size()));
		
		} else {
			errorString = "No subordinations";
		}
	
		if (errorString == null) {
			isRedirect = false;
			session.setAttribute("subs", subs);
			path = JSPEnum.SUBORDINATION_EDIT.getPath();
			request.setAttribute("employeeID", employeeID);
			request.setAttribute("page", page);
		} else {
			isRedirect = true;
			request.setAttribute("errorString", errorString);
			path = JSPEnum.EMPLOYEE_EDIT.getPath();
		}
		
		
		
	}

	@Override
	public void executePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
