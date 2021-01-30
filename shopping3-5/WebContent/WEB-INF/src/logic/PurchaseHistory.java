package logic;

import java.util.List;

public interface PurchaseHistory {

	// サービスクラスの呼び出し
	List<PurchaseHistorySet> getPurchaseHistoryList(String userId);

}
