package service;

import java.util.List;
import java.util.Map;

public interface UserService {

	public String insertUser(Map<String, String> hm);//회원가입
	public Map<String, String> selectUser(Map<String, String> hm);//회원 정보 검색
	public int deleteUser(Map<String, String>hm);//회원 탈퇴 및 삭제
	public int updateUser(Map<String, String>hm);//회원 정보 수정
	public List<Map<String,String>>	selectUserList(Map<String,String>hm	);//회원 리스트 검색
} 
