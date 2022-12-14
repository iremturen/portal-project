package com.izibiz.training.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import com.izibiz.training.dao.base.StockDao;
import com.izibiz.training.dao.common.GenericDaoHibernateImpl;
import com.izibiz.training.entity.Stock;
import com.izibiz.training.entity.dto.StockDTO;

@Repository
public class StockDaoImp extends GenericDaoHibernateImpl<Stock> implements StockDao {

	private static final Logger logger = Logger.getLogger(StockDaoImp.class);

	private static final long serialVersionUID = 1L;

	public StockDaoImp() {
		super(Stock.class);
	}

	@Override
	public List<StockDTO> getStockDtos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		logger.debug("start StockDaoImp.getStockDtos with params ");

		String sql = "SELECT s.id AS id," + "s.inventoryId AS inventoryId," + "s.brand AS brand," + "s.name AS name,"
				+ "s.quantity AS quantity," + "s.unitPrice AS unitPrice ," + "s.uuid AS uuid ," + "s.email AS email "
				+ "FROM IREM_TUREN.STOCKS s" + " WHERE 1=1 ";

		StringBuilder sqlBuilder = new StringBuilder(sql);

		filter(sqlBuilder, filters);

		if (sortField != null) {
			sort(sqlBuilder, sortField, sortOrder);
		}

		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sqlBuilder.toString());
		sqlQuery.setResultTransformer(Transformers.aliasToBean(StockDTO.class));

		setFilterParameter(sqlQuery, filters);

		sqlQuery.addScalar("id", LongType.INSTANCE);
		sqlQuery.addScalar("inventoryId", StringType.INSTANCE);
		sqlQuery.addScalar("brand", StringType.INSTANCE);
		sqlQuery.addScalar("name", StringType.INSTANCE);
		sqlQuery.addScalar("quantity", BigDecimalType.INSTANCE);
		sqlQuery.addScalar("unitPrice", BigDecimalType.INSTANCE);
		sqlQuery.addScalar("uuid", StringType.INSTANCE);
		sqlQuery.addScalar("email", StringType.INSTANCE);

		sqlQuery.setFirstResult(first);
		sqlQuery.setMaxResults(pageSize);

		List<StockDTO> stockDTOs = sqlQuery.list();

		logger.debug("end StockDaoImp.getStockDtos with params ");

		return sqlQuery.list();

	}

	private void buildSql(StringBuilder sqlBuilder, Map<String, Object> filters) {
		for (Entry<String, Object> filter : filters.entrySet()) {
			String key = filter.getKey();
			Object value = filter.getValue();
			switch (key) {
			case "brand":
				sqlBuilder.append(" WHERE brand=").append(value);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public long getStockDtoCount(Map<String, Object> filters) {

		long resultCount = 0;

		String sql = "SELECT count(*)" + "FROM IREM_TUREN.STOCKS s ";

		StringBuilder sqlBuilder = new StringBuilder(sql);
		buildSql(sqlBuilder, filters);

		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sqlBuilder.toString());

		Number count = (Number) sqlQuery.uniqueResult();
		if (count != null)
			resultCount = count.longValue();

		return resultCount;
	}

	public void filter(StringBuilder sqlBuilder, Map<String, Object> filters) {

		for (Entry<String, Object> filter : filters.entrySet()) {
			String key = filter.getKey();
			Object value = filter.getValue();

			switch (key) {
			case "id":
				if (value != null) {
					sqlBuilder.append(" AND ID LIKE :id ");
				}
				break;
			case "uuid":
				if (value != null) {
					sqlBuilder.append(" AND UUID LIKE :uuid");
				}
				break;
			case "inventoryId":
				if (value != null) {
					sqlBuilder.append(" AND INVENTORYID LIKE :inventoryId");
				}
				break;
			case "name":
				if (value != null) {
					sqlBuilder.append(" AND NAME LIKE :name ");
				}
				break;
			case "brand":
				if (value != null) {
					sqlBuilder.append(" AND BRAND LIKE :brand ");
				}
				break;
			case "email":
				if (value != null) {
					sqlBuilder.append(" AND EMAIL LIKE :email ");
				}
				break;
			case "unitPrice":
				if (value != null) {

					sqlBuilder.append(" AND UNITPRICE LIKE :unitPrice ");
				}
				break;
			case "quantity":
				if (value != null) {
					sqlBuilder.append(" AND QUANTITY LIKE :quantity ");
				}
				break;
			default:
				break;
			}
		}

	}

	public void setFilterParameter(SQLQuery sql, Map<String, Object> filters) {

		for (Entry<String, Object> filter : filters.entrySet()) {
			String key = filter.getKey();
			Object value = filter.getValue();

			switch (key) {
			case "id":
				if (value != null) {
					sql.setParameter("id", "%" + value + "%");
				}
				break;
			case "uuid":
				if (value != null) {
					sql.setParameter("uuid", "%" + value + "%");
				}
				break;
			case "inventoryId":
				if (value != null) {
					sql.setParameter("inventoryId", "%" + value + "%");
				}
				break;
			case "name":
				if (value != null) {
					sql.setParameter("name", "%" + value + "%");
				}
				break;
			case "brand":
				if (value != null) {
					sql.setParameter("brand", "%" + value + "%");
				}
				break;
			case "email":
				if (value != null) {
					sql.setParameter("email", "%" + value + "%");
				}
				break;
			case "unitPrice":
				if (value != null) {
					sql.setParameter("unitPrice", "%" + value + "%");
				}
				break;
			case "quantity":
				if (value != null) {
					sql.setParameter("quantity", "%" + value + "%");
				}
				break;
			default:
				break;
			}
		}
	}

	public void sort(StringBuilder builder, String sortField, SortOrder sortOrder) {

		if (!StringUtils.isEmpty(sortField)) {
			builder.append(" ORDER BY ");

			switch (sortField) {

			case "id":
				builder.append("id ");
				break;
			case "uuid":
				builder.append("uuid ");
				break;
			case "iventoryId":
				builder.append("iventoryId");
				break;
			case "name":
				builder.append("name ");
				break;
			case "email":
				builder.append("email");
				break;
			case "brand":
				builder.append("brand");
				break;
			case "quantity":
				builder.append("quantity");
				break;
			case "unitPrice":
				builder.append("unitPrice");
				break;
			default:
				break;
			}

			if (SortOrder.ASCENDING.toString().equals(sortOrder.toString())) {
				builder.append("ASC");
			} else {
				builder.append("DESC");
			}
		}

	}

}
