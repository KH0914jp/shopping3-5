package logic;

import java.util.List;

public interface PurchaseHistory {

	// �T�[�r�X�N���X�̌Ăяo��
	List<PurchaseHistorySet> getPurchaseHistoryList(String userId);

}
