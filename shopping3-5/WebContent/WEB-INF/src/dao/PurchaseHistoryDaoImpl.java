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
	private static final String SELECT_PURCHASEHISTORY = "SELECT" +
			"    sl.UPDATE_TIME" +
			"    , sl.ITEM_ID" +
			"    , sl.QUANTITY" +
			"    , i.ITEM_NAME" +
			"    , i.PRICE" +
			" FROM" +
			"    sale_line sl" +
			"    INNER JOIN item i" +
			"        ON sl.ITEM_ID = i.ITEM_ID" +
			"    INNER JOIN sale s" +
			"        ON s.SALE_ID = sl.SALE_ID" +
			" WHERE" +
			"    s.USER_ID = ?" +
			" ORDER BY" +
			"    sl.UPDATE_TIME DESC" +
			"    , sl.ITEM_ID ASC";

	// �w�������擾SQL���s���\�b�h
	public List<PurchaseHistorySet> getPurchasehistory(String userId) {
		// mapper��PurchaseHistorySet�N���X�̒l���Z�b�g
		RowMapper<PurchaseHistorySet> mapper = new BeanPropertyRowMapper<PurchaseHistorySet>(PurchaseHistorySet.class);
		// �w�������擾SQL��PurchaseHistorySet�N���X�̒l��UserId�������ɂ���SQL�̎��s���ʂ�ԋp
		return this.template.query(PurchaseHistoryDaoImpl.SELECT_PURCHASEHISTORY, mapper, userId);
	}
}