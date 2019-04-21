package com.gupaoedu.vip.orm.demo.dao;

import com.gupaoedu.vip.orm.demo.entity.Member;
import com.gupaoedu.vip.orm.framework.BaseDaoSupport;
import com.gupaoedu.vip.orm.framework.QueryRule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 2019/4/20.
 */
@Repository
public class MemberDao extends BaseDaoSupport<Member,Long> {

    //JdbcTemplate jdbcTemplate;

    @Override
    protected String getPKColumn() {
        return "id";
    }

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource){
        //jdbcTemplate = new JdbcTemplate(dataSource);
        super.setDataSourceReadOnly(dataSource);
        super.setDataSourceWrite(dataSource);
    }

    public List<Member> selectAll() throws  Exception{
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andLike("name","Tom%");

        return super.select(queryRule);
    }

}
