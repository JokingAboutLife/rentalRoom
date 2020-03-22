package com.gxust.edu.rental_room.utils;

import com.gxust.edu.rental_room.domain.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author With Me
 * @description
 * @date 2020/3/22
 * 方欣科技/社保事业部
 * 修改记录
 * 修改人：     修改日期:        版本：         修改内容:
 * With Me  2020/3/22 18:30    1.0
 */
public class TreeUtil {
    public static List<Permission> getMenuTree(List<Permission> menusBase, List<Permission> menuLeaf) {
        for (Permission menu : menusBase) {
            List<Permission> menus = iterateMenus(menuLeaf, menu.getId());
            menu.setChildren(menus);
        }
        return menusBase;
    }

    /**
     * 多级菜单查询方法
     *
     * @param permissionsVoList 不包含最高层次菜单的菜单集合
     * @param pid        父类id
     * @return
     */
    public static List<Permission> iterateMenus(List<Permission> permissionsVoList, Integer pid) {
        List<Permission> result = new ArrayList<Permission>();
        for (Permission permission : permissionsVoList) {
            //获取菜单的id
            Integer menuid = permission.getId();
            //获取菜单的父id
            Integer parentid = permission.getParentId();
            if (parentid != null) {
                if (parentid == pid) {
                    //递归查询当前子菜单的子菜单
                    List<Permission> iterateMenu = iterateMenus(permissionsVoList, menuid);
                    permission.setChildren(iterateMenu);
                    result.add(permission);
                }
            }
        }
        return result;
    }
}
