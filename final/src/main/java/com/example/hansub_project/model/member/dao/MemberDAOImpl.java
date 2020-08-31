package com.example.hansub_project.model.member.dao;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.domain.UsersVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;

	// ȸ�� ���� ���� �޼ҵ�
	// ��ư�� Ŭ���� ȸ���� ������ ȸ�� ���̺� �����ؼ� ����� �� �ְ� ��
	@Override
	public void authentication(UsersVO vo) {

		sqlSession.insert("member.authentication", vo);

	}

}
