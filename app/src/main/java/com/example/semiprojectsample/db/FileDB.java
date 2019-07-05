package com.example.semiprojectsample.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.semiprojectsample.bean.MemberBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class FileDB {
    private static final String FILE_DB = "FileDB";
    private static Gson mGson = new Gson();

    private static SharedPreferences getSP(Context context) {
       SharedPreferences sp = context.getSharedPreferences(FILE_DB, Context.MODE_PRIVATE);
       return sp;
    }

    /** 새로운 멤버추가 **/
    public static void addMember(Context context, MemberBean memberBean) {
       // 1. 기존의 멤버 리스트를 불러온다.
        List<MemberBean> memberList = getMemberList(context);
        // 2. 기존의 멤버 리스트에 추가한다.
        memberList.add(memberBean);
        // 3. 멤버 리스트를 저장한다.
        String listStr = mGson.toJson(memberList);
        // 4. 저장한다.
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putString("memberList", listStr);
        editor.commit();
    }

    public static List<MemberBean> getMemberList(Context context) {
        String listStr = getSP(context).getString("memberList", null);
        // 저장된 리스트가 없을 경우에 새로운 리스트를 리턴한다.
        if(listStr == null) {
            return new ArrayList<MemberBean>();
        }
        // Gson으로 변환한다.
        List<MemberBean> memberList = mGson.fromJson(listStr, new TypeToken<List<MemberBean>>(){}.getType());
        return memberList;
    }

    public static MemberBean getFindMember(Context context, String memId) {
        // 1. 멤버리스트를 가져온다
        // 2. for 문 돌면서 해당 아이디를 찾는다.
        // 3. 찾았을 경우는 해당 MemberBean 을 리턴한다.
        // 3-2. 못찾았을 경우는??? null 리턴

        return null;
    }
}
