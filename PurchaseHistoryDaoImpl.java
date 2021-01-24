package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.PurchaseHistorySet;

@Repository
public class PurchaseHistoryDaoImpl implements PurchaseHistoryDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	// �w�������擾SQL
	private static final String SELECT_PURCHASEHISTORY = "select sale_line.UPDATE_TIME, sale_line.ITEM_ID, sale_line.QUANTITY,   item.ITEM_NAME, item.PRICE from sale_line inner join item on sale_line.ITEM_ID = item.item_id inner join sale on sale.SALE_ID = sale_line.SALE_ID WHERE sale.USER_ID = ? ORDER BY sale_line.UPDATE_TIME DESC, sale_line.ITEM_ID ASC";

	// �w�������擾SQL���s���\�b�h
	public List<PurchaseHistorySet> getPurchasehistory(String userId) {
		// mapper��PurchaseHistorySet�N���X�̒l���Z�b�g
		RowMapper<PurchaseHistorySet> mapper = new BeanPropertyRowMapper<PurchaseHistorySet>(PurchaseHistorySet.class);
		// �w�������擾SQL��PurchaseHistorySet�N���X�̒l��UserId�������ɂ���SQL�̎��s���ʂ�ԋp
		return this.template.query(PurchaseHistoryDaoImpl.SELECT_PURCHASEHISTORY, mapper, userId);
	}
}