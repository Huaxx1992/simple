package com.simple.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeKit {

	private String ATTR_KEY_NAME = "id"; // 根节点值
	private String ATTR_PARENT_NAME = "pid"; // 根节点值
	private String DEFAULT_ROOT_VALUE = ""; // 根节点值

	// 私有构造器
	private TreeKit() {
		super();
	}

	public static TreeKit instance(String keyName, String pKeyName) {
		TreeKit newKit = new TreeKit();
		newKit.ATTR_KEY_NAME = keyName;
		newKit.ATTR_PARENT_NAME = pKeyName;
		return newKit;
	}

	public static TreeKit instance() {
		return new TreeKit();
	}

	public List<Map<String, Object>> format(List<Map<String, Object>> target, Object hitValue) {
		return screenChildren(target, hitValue);
	}

	public List<Map<String, Object>> format(List<Map<String, Object>> target) {
		return screenChildren(target, DEFAULT_ROOT_VALUE);
	}

	// 格式化并且创建一个根节点
	public Map<String, Object> formatAndCreateRoot(List<Map<String, Object>> target, Map<String, Object> root) {
		root.put("children", screenChildren(target, root.get(ATTR_KEY_NAME)));
		return root;
	}

	// 格式化并且指定一个根节点
	public Map<String, Object> formatAndAppointRoot(List<Map<String, Object>> target, Object AppointKey) {
		for (Map<String, Object> m : target) {
			Object tKey = m.get(ATTR_KEY_NAME);
			if (AppointKey.equals(m.get(tKey))) {
				m.put("children", screenChildren(target, tKey));
				return m;
			}
		}
		return new HashMap<>();
	}

	private List<Map<String, Object>> screenChildren(List<Map<String, Object>> target, Object hitValue) {
		List<Map<String, Object>> childrenList = new ArrayList<>();
		for (Map<String, Object> m : target) {
			if (hitValue.equals(m.get(ATTR_PARENT_NAME))) {
				Object tKey = m.get(ATTR_KEY_NAME);
				m.put("children", screenChildren(target, tKey));
				childrenList.add(m); // 加入到子集
			}
		}
		return childrenList;
	}

}
