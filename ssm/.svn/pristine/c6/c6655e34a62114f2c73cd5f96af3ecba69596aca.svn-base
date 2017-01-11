package com.hz.business.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.hz.base.Constants;
import com.hz.base.utils.DateUtil;
import com.hz.base.utils.StringUtil;
import com.hz.business.base.pojo.Group;
import com.hz.business.base.pojo.GroupExample;
import com.hz.business.base.pojo.GroupUser;
import com.hz.business.service.DaoManager;
import com.hz.business.service.GroupService;

public class GroupServiceImpl implements GroupService {
	@Resource DaoManager manager;

	public Group createGroup(String userId , String groupName , String groupUsers ,String groupDesc ) {
		Group group = new Group();
		
		group.setCreatePersonId(userId);
		group.setCreateTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
		group.setName(groupName);
		group.setGroupDesc(groupDesc);
		group.setStatus(Constants.GROUP_STATUS_VALID);
		group.setHaveOpenSign(0);
		int result = manager.getGroupMapper().insertSelective(group);
		
		if(result == 1){
			String[] users = groupUsers.split("\\|");
			if(users != null && users.length>0){
				for(String user : users){
					GroupUser gu = new GroupUser();
					gu.setGroupId(group.getId()+"");
					gu.setStatus(1);
					gu.setUserId(user);
					gu.setCreateTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
					result = manager.getGroupUserMapper().insertSelective(gu);
					if(result != 1) break;
				}
			}
		}
		
		return result == 1 ? group : null;
		 
	}

	public List<Group> groupListByUserId(String userId, int type) {
		 List<Group> list = manager.getGroupMapper().selectGroupListByUserId(userId, type);
		 return (list != null && list.size()>0) ?  list : null; 
	}

	public boolean delGroup(String groupId) {
		Group record = new Group();
		if( StringUtil.isNotBlank(groupId)){
			record.setId(Integer.valueOf(groupId));
			record.setStatus(2);
			int result = manager.getGroupMapper().updateByPrimaryKeySelective(record);
			//int result = manager.getGroupMapper().deleteByPrimaryKey(Integer.valueOf(groupId)); //物理删
			return result ==1 ? true : false;
		}else{
			return false;
		}
	}

	public boolean updateGroup(Integer groupId, String groupName, String groupDesc, Integer haveOpenSign) {
		Group group = new Group();
	//	group.setId(groupId);
		if(StringUtil.isNotBlank(groupName)){
			group.setName(groupName);
		}
		if(StringUtil.isNotBlank(groupDesc)){
			group.setGroupDesc(groupDesc);
		}
		
		if(haveOpenSign==1){
			group.setHaveOpenSign(haveOpenSign);
		}else if(haveOpenSign==2){
			group.setHaveOpenSign(0);
		}
		GroupExample example = new GroupExample();
		example.createCriteria().andIdEqualTo(groupId);
		manager.getGroupMapper().updateByExampleSelective(group, example);
		return true;
	}
	
	
	

}
