/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Entity;


/**
 *
 * @author mhodes
 */

@Entity
@Table(name = "DBMAINMENU")
public class DBMainMenu {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)

     @Column(name = "MENU_ID")
     private int menuId;

     @Column(name = "MENU_NAME")
     private String menuName;

     public DBMainMenu(){
     }

     public DBMainMenu(Integer id, String name){
        this.menuId = id;
        this.menuName = name;
     }

    /**
     * @return the menuId
     */
    public int getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}