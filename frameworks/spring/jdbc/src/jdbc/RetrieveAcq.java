package jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.sql.*;

public class RetrieveAcq extends NamedParameterJdbcDaoSupport {

	public static final String ACQ_SELECT = "select f_name, l_name, city from acquantances where f_name = :fname and l_name = :lname";

	public Acquantance getAcq (String fname, String lname)  {
		

		Acquantance acq = new Acquantance();
		Map params = new HashMap();
		params.put("fname", fname);
		params.put("lname", lname);

		List matches = getNamedParameterJdbcTemplate().query(ACQ_SELECT, params,
			new RowMapper() {
				public Object mapRow(ResultSet rset, int rowNum) throws SQLException, DataAccessException {
					Acquantance acq = new Acquantance();
					acq.setFname(rset.getString(1));
					acq.setLname(rset.getString(2));
					acq.setCity(rset.getString(3));
					return acq;
				}
			}
		);
		if (matches.size() > 0)  {
			acq = (Acquantance) matches.get(0);  // ASSUMES one is returned
		}
		return acq;
	}
}
