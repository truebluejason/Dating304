package facadeUI;
import java.util.List;

import pkg304data.*;

public class ViFacade implements DaFacade {
	private LogInManager LogInMan;
	private UserManager UserMan;
	private Viewer viewer;
	
	ViFacade() {
		LogInMan = LogInManager.getInstance();
		UserMan = UserManager.getInstance();
		viewer = Viewer.getInstance();
	}

	@Override
	public void login(String id) {
		LogInMan.login(id);
	}
	
	@Override
	public void logout() {
		LogInMan.logout();
	}

	@Override
	public void getMatch() {
		UserMan.getMatch();
	}

	@Override
	public void getMessage(String id) {
		UserMan.getMessage(id);
	}

	@Override
	public void sendMessage(String id, String msg) {
		UserMan.sendMessage(id, msg);
	}

	@Override
	public void buyPrem(String pName) {
		UserMan.buyPrem(pName);
	}

	@Override
	public void cancelPrem(String type) {
		UserMan.cancelPrem(type);
	}

	@Override
	public void uploadImage(String url) {
		UserMan.uploadImage(url);
	}

	@Override
	public void deleteImage(String url) {
		UserMan.deleteImage(url);
	}
	
	@Override
	public void getImage() {
		UserMan.getImage();
	}

	@Override
	public void signUp(String email, String name, String gender, int pID) {
		LogInMan.signUp(email, name, gender, pID);
	}

	@Override
	public void deactivate() {
		LogInMan.deactivate();
	}

	@Override
	public PaymentInfo viewPaymentInfo() throws Exception {
		return UserMan.viewPaymentInfo();
	}
	
	@Override
	public void addPaymentInfo(String cardType, String cardNo, String address) {
		UserMan.addPaymentInfo(cardType, cardNo, address);
	}
	
	@Override
	public void deletePaymentInfo() {
		UserMan.deletePaymentInfo();
	}

	@Override
	public void showUserStats() {
		viewer.showUserStats();
	}

	@Override
	public void showBuyRecords() {
		viewer.showBuyRecords();
	}
	
	@Override
	// Display all available premium options
	public List<PremiumPackage> viewPrem() throws Exception{
		return viewer.viewPrem();
	}
	
	@Override
	// Display all premium this user has
	public List<PremiumPackage> myPremiums() throws Exception{
		return UserMan.myPremiums();
	}

	@Override
	// Displays broken matches by type for a specific user.
	public void getBrokenMatchesByType() {
		UserMan.getBrokenMatchesByType();
	}
	
	@Override
	public void deactivateMatch(String id) {
		UserMan.deactivateMatch(id);
	}
}
