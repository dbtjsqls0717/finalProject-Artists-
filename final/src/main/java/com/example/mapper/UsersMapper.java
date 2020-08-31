package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.UsersVO;

public interface UsersMapper {
   public List<UsersVO> list();
   public List<UsersVO> proimage();
   public int login(UsersVO vo);
   public UsersVO read(String id);
   public void insert(UsersVO vo);
   
   public int followChk(@Param(value="follower")String follower,@Param(value="target")String target);
   public void followInsert(@Param(value="follower")String follower,@Param(value="target")String target);
   public void followDelete(@Param(value="follower")String follower,@Param(value="target")String target);
   public int followerCnt(String target);
   public int followingCnt(String follower);
   public void followerUpdate(@Param(value="follower") int followerCnt, @Param(value="id") String target);
   public void followUpdate(@Param(value="follow") int followingCnt, @Param(value="id") String follower);
   /*�븘�씠�뵒 李얘린*/
   public int find_id_cnt(String email);
   public UsersVO find_id(String email);
   /*鍮꾨�踰덊샇 李얘린 遺�遺�*/
   public int find_email_cnt(String id);
   public UsersVO find_email(String email);
   /*鍮꾨�踰덊샇 蹂�寃� 遺�遺�*/
   public void update(UsersVO vo);
   
   public void profile_update(UsersVO vo);
   
   public void profile_passUpdate(UsersVO vo);
   
   public void updatePosition(String id);
   public int eread(String email);
   //admin 유저관리
   public List<UsersVO> userList(Criteria cri);
   public int usercnt();
   public void positionChange(UsersVO vo);
   
}