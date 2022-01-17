package com.example.paper.dao;

import com.example.paper.vo.ReceivePaperVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("receivePaperDao")
public class ReceivePaperDaoImpl implements ReceivePaperDao{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertPaper(ArrayList<ReceivePaperVo> receiveVo, int sendPaperNo) {
        for(ReceivePaperVo receivePaper: receiveVo) {
            receivePaper.setSendPaperNo(sendPaperNo);
            this.sqlSession.insert("Paper.insertReceivePaper",receivePaper);
        }

    }
    @Override
    public List<ReceivePaperVo> selectReceivePaperList(String receiveId) {
        return this.sqlSession.selectList("Paper.selectReceivePaperList",receiveId);
    }

}
