package com.example.project01_cdtalk.opentalk;

import com.example.project01_cdtalk.R;

import java.util.ArrayList;

public class OpenSubDAO {
    OpenSubDTOs dtos;

    public OpenSubDAO() {
        dtos = new OpenSubDTOs();
    }

    public ArrayList<OpenSubDTOs.OpenSub1DTO> getOpenSub1List(){
        ArrayList<OpenSubDTOs.OpenSub1DTO> list = new ArrayList<>();
        list.add(dtos. new OpenSub1DTO(R.drawable.profile0, 1500, "[광주광역시 정보] 광주전남 정보", "사진을 3장 보냈습니다.", "12월 7일"));
        list.add(dtos. new OpenSub1DTO(R.drawable.profile1, 2000, "채팅방2", "사진을 3장 보냈습니다.", "12월 7일"));
        list.add(dtos. new OpenSub1DTO(R.drawable.profile2, 100, "한울", "사진을 3장 보냈습니다.", "12월 7일"));
        list.add(dtos. new OpenSub1DTO(R.drawable.profile3, 10, "아무 방", "사진을 3장 보냈습니다.", "12월 7일"));
        list.add(dtos. new OpenSub1DTO(R.drawable.profile4, 5, "게임톡", "사진을 3장 보냈습니다.", "12월 7일"));
        return list;
    }
    public ArrayList<OpenSubDTOs.OpenSub2DTO> getOpenSub2List1(){
        ArrayList<OpenSubDTOs.OpenSub2DTO> list = new ArrayList<>();
        list.add(dtos.new OpenSub2DTO(R.drawable.profile4,10, "쇠질은 인생이야", "방금 대화", new String[]{"#헬스","#크로스핏","#헬창","#오운"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile5,20, "간헐적 단식 & 혈당 관리", "30분 전", new String[]{"#다이어트","#혈당관리","#간헐적단식","#체중감량"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile6,30, "다이어트 공유 식단/운동", "30분 전", new String[]{"#다이어트","#다이어트음식","#다이어트식단","#헬스"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile7,40, "10대 다이어트/운동방", "방금 대화", new String[]{"#중고등학생","#운동","#11년생"}));
        String[] arr = {"aa","aa"};
        return list;
    }
    public ArrayList<OpenSubDTOs.OpenSub2DTO> getOpenSub2List2(){
        ArrayList<OpenSubDTOs.OpenSub2DTO> list = new ArrayList<>();
        list.add(dtos.new OpenSub2DTO(R.drawable.profile4,10, "대구경북 사진러브", "방금 대화", new String[]{"#대구","#경북","#취미","#사진","#동아리"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile5,20, "대전사진모음", "", new String[]{"#사진","#카메라","#출사","#여행", "#보정"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile6,30, "사진을즐기는사람들", "방금 대화", new String[]{"#[서울-경기]상업/일반인으로 구성된 사진모음"}));
        list.add(dtos.new OpenSub2DTO(R.drawable.profile7,40, "사진공방 : 사진을 만드는 사람들", "방금 대화", new String[]{"#캐논","#니콘","#소니", "#후지", "#올림푸스"}));
        return list;
    }
    public ArrayList<OpenSubDTOs.OpenSub3DTO> getOpenSub3List(){
        ArrayList<OpenSubDTOs.OpenSub3DTO> list = new ArrayList<>();
        list.add(dtos. new OpenSub3DTO(R.drawable.profilebg0,550,"메월드 로나월드", "방금 대화"));
        list.add(dtos. new OpenSub3DTO(R.drawable.profilebg1,820,"뉴비 환영 니케\n챗방", "방금 대화"));
        list.add(dtos. new OpenSub3DTO(R.drawable.profilebg2,1497,"자유로운 올팜방", "방금 대화"));
        list.add(dtos. new OpenSub3DTO(R.drawable.profilebg3,933,"메이플스토리월드\n아르테일 서버...", "방금 대화"));
        return list;
    }
}
