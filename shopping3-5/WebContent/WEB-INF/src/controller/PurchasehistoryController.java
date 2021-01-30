package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.PurchaseHistory;
import logic.PurchaseHistorySet;
import logic.User;
import utils.WebConstants;

@Controller
public class PurchasehistoryController {

	@Autowired
	private PurchaseHistory purchaseHistory;


	// end.jsp�Ŏw�肵�Ă���w��������ʑJ�ڐ惊���N
	@RequestMapping(value = "/purchasehistory/purchasehistory")
	public ModelAndView history(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("/purchasehistory/purchasehistory");

		// ���O�C�����[�U���擾
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}

		// UserId�������ɃT�[�r�X�N���X�Ăяo�����\�b�h�����s���A�ϐ��ɍw�������擾���ʂ��i�[
		List<PurchaseHistorySet> purchaseHistorySet= purchaseHistory.getPurchaseHistoryList(loginUser.getUserId());

		// �w����������ݒ�
		modelAndView.addObject("purchasehistory", purchaseHistorySet);

		return modelAndView;
	}
}