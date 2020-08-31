package com.example.hansub_project.service.member;



import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.example.domain.UsersVO;
import com.example.hansub_project.model.member.dao.MemberDAO;


@Service //���� �� ����
public class MemberSerivceImpl implements MemberService {
 
    
    @Inject    
    MemberDAO memberdao; //dao�� ����ϱ� ���� �������� ����

    @Override
    public void authentication(UsersVO vo) {
        
        memberdao.authentication(vo);
    }

}