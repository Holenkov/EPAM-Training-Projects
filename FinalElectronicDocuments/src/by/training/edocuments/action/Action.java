package by.training.edocuments.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Action {
	protected String path;
	protected Boolean isRedirect;
	protected String parameters = "";

	public abstract void executeGet (HttpServletRequest request, HttpServletResponse response);
	public abstract void executePost (HttpServletRequest request, HttpServletResponse response);
	
	public Action() {
		isRedirect = false;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Boolean getIsRedirect() {
		return isRedirect;
	}
	public void setIsRedirect(Boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	
	
	
	
	
	/*public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
		Forward forward = new Forward("/user/edit.html");
		try {
			Validator<User> validator = ValidatorFactory.createValidator(User.class);
			User user = validator.validate(request);
			UserService service = factory.getService(UserService.class);
			service.save(user);
			forward.getAttributes().put("identity", user.getIdentity());
			forward.getAttributes().put("message", "Данные сотрудника успешно сохранены");
			logger.info(String.format("User \"%s\" saved user with identity %d", getAuthorizedUser().getLogin(), user.getIdentity()));
		} catch(IncorrectFormDataException e) {
			forward.getAttributes().put("message", "Были обнаружены некорректные данные");
			logger.warn(String.format("Incorrect data was found when user \"%s\" tried to save user", getAuthorizedUser().getLogin()), e);
		}
		return forward;
	}*/

}
