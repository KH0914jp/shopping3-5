package dao;

import java.util.List;

import logic.PurchaseHistorySet;

public interface PurchaseHistoryDao {
	// �w�������擾SQL���s�N���X�Ăяo��
	List<PurchaseHistorySet> getPurchasehistory(String userId);
}