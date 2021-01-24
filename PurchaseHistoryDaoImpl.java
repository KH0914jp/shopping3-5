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
	private static final String SELECT_PURCHASEHISTORY = "select sale_line.UPDATE_TIME, sale_line.ITEM_ID, sale_line.QUANTITY,   item.ITEM_NAME, item.PRICE from sale_line inner join item on sale_line.ITEM_ID = item.item_id inner join sale on sale.SALE_ID = sale_line.SALE_ID WHERE sale.USER_ID = ? ORDER BY sale_line.UPDATE_TIME DESC, sale_line.ITEM_ID ASC";

	// 購入履歴取得SQL実行メソッド
	public List<PurchaseHistorySet> getPurchasehistory(String userId) {
		// mapperにPurchaseHistorySetクラスの値をセット
		RowMapper<PurchaseHistorySet> mapper = new BeanPropertyRowMapper<PurchaseHistorySet>(PurchaseHistorySet.class);
		// 購入履歴取得SQLとPurchaseHistorySetクラスの値とUserIdを引数にしてSQLの実行結果を返却
		return this.template.query(PurchaseHistoryDaoImpl.SELECT_PURCHASEHISTORY, mapper, userId);
	}
}