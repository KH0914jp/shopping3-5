package dao;

import java.util.List;

import logic.PurchaseHistorySet;

public interface PurchaseHistoryDao {
	// 購入履歴取得SQL実行クラス呼び出し
	List<PurchaseHistorySet> getPurchasehistory(String userId);
}