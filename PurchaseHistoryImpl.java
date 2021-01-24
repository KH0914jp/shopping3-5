package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PurchaseHistoryDao;

@Service
public class PurchaseHistoryImpl implements PurchaseHistory{

	@Autowired
	private PurchaseHistoryDao purchaseHistory;

	// Daoのインターフェイスクラスを呼び出し
	public List<PurchaseHistorySet> getPurchaseHistoryList(String userId) {
		return purchaseHistory.getPurchasehistory(userId);
	}

}
