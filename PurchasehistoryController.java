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


	// end.jspで指定している購入履歴画面遷移先リンク
	@RequestMapping(value = "/purchasehistory/purchasehistory")
	public ModelAndView history(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("/purchasehistory/purchasehistory");

		// ログインユーザを取得
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}

		// UserIdを引数にサービスクラス呼び出しメソッドを実行し、変数に購入履歴取得結果を格納
		List<PurchaseHistorySet> purchaseHistorySet= purchaseHistory.getPurchaseHistoryList(loginUser.getUserId());

		// 購入履歴情報を設定
		modelAndView.addObject("purchasehistory", purchaseHistorySet);

		return modelAndView;
	}
}