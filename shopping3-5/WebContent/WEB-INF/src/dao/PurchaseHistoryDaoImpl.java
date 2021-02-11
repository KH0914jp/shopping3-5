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

	// 購入履歴取得SQL
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

	// 購入履歴取得SQL実行メソッド
	public List<PurchaseHistorySet> getPurchasehistory(String userId) {
		// mapperにPurchaseHistorySetクラスの値をセット
		RowMapper<PurchaseHistorySet> mapper = new BeanPropertyRowMapper<PurchaseHistorySet>(PurchaseHistorySet.class);
		// 購入履歴取得SQLとPurchaseHistorySetクラスの値とUserIdを引数にしてSQLの実行結果を返却
		return this.template.query(PurchaseHistoryDaoImpl.SELECT_PURCHASEHISTORY, mapper, userId);
	}
}