package poc.spring.mvc.rest.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DictionaryDAOImpl implements DictionaryDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Entry lookup(String word) {
		String sql = "select * from ENTRY where word = ?";
		Entry entry = jdbcTemplateObject.queryForObject(sql, new Object[] { word }, new EntryMapper());
		
		if (entry==null) return null;
		
		sql="select * from EXAMPLE where word=?";
	    List <Example> examples = jdbcTemplateObject.query(sql, new Object[] { word },new ExampleMapper());

	    entry.setSamples(examples);
		return entry;
	}

	
	public static class EntryMapper implements RowMapper<Entry> {
		   public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Entry entry = new Entry();
		      entry.setId(rs.getLong("ID"));
		      entry.setWord(rs.getString("WORD"));
		      entry.setExplanation(rs.getString("EXPLANATION"));
		      entry.setMediaPath(rs.getString("MEDIA_PATH"));
		      
		      return entry;
		   }
	}
	
	public static class ExampleMapper implements RowMapper<Example> {
		   public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Example example = new Example();
		      example.setId(rs.getLong("ID"));
		      example.setSentence(rs.getString("SENTENCE"));
		      example.setMediaPath(rs.getString("MEDIA_PATH"));
		      
		      return example;
		   }
	}
	
}
