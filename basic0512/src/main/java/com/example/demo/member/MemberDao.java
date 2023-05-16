package com.example.demo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.util.DBConnectionMgr;
public class MemberDao {
    Logger logger = Logger.getLogger(MemberDao.class);
    DBConnectionMgr dbMgr = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public MemberDao() {
       dbMgr = DBConnectionMgr.getInstance();
    }
    public List<Map<String,Object>> memberList(){
       logger.info("memberList");
       List<Map<String,Object>> mList = new ArrayList<>();
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT mem_id, mem_pw, mem_name FROM member2022");
       try {
          con = dbMgr.getConnection();
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          Map<String,Object> rmap = null;
          while(rs.next()) {
             rmap = new HashMap<>();
             rmap.put("mem_id", rs.getString("mem_id"));
             rmap.put("mem_pw", rs.getString("mem_pw"));
             rmap.put("mem_name", rs.getString("mem_name"));
             mList.add(rmap);
          }
          logger.info(mList);
       } catch (SQLException se) {
          logger.info(se.toString());
       } catch (Exception e) {
          logger.info(e.toString());
       }
       return mList;
    }
}
